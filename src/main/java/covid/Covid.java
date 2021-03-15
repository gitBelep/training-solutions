package covid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Covid {
    private CitizenDao dao = new CitizenDao();

    public void readMassRegistrationFile(String pathStr) {
        Path path = Path.of(pathStr);
        if (!Files.exists(path)){
            throw new IllegalArgumentException("File does not exist.");
        }
        List<String> mass = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            skipHeader(br);
            while ((line = br.readLine()) != null) {
                mass.add(line);
            }
            verifyCitizenDatas(mass);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void skipHeader(BufferedReader br) throws IOException{
        br.readLine();
    }

    private void verifyCitizenDatas(List<String> mass) {
        Validation v = new Validation();
        List<Citizen> citizens = new ArrayList<>();
        for (String s : mass) {
            String[] data = s.split(";");
            String name = v.nameIsValid(data[0]);
            String zipCode = v.isZipValid(data[1]);
            int age = v.getAge(data[2]);
            String email = v.isEmailValid(data[3], data[3]);
            String numberTAJ = v.isTajValid(data[4]);
            citizens.add(new Citizen(name, zipCode, age, email, numberTAJ, 0));
        }
        dao.registerCitizen(citizens);
    }

    public void selectCitizens(String zipStr, String fileName) {
        List<Citizen> result = dao.chooseCitizensForVaccination(zipStr);
        createCitizensFile(fileName, result);
    }

    private void createCitizensFile(String file, List<Citizen> citizens) {
        Path filePath = Path.of("d:", "covid", file);
        try (BufferedWriter bw = Files.newBufferedWriter(filePath)) {
            writeCitizensFile(bw, citizens);
        } catch (IOException ex) {
            throw new IllegalStateException("Cannot write file", ex);
        }
    }

    private void writeCitizensFile(BufferedWriter bw, List<Citizen> citizens) throws IOException{
        LocalTime firstVaccination = LocalTime.of(8, 0);
        StringBuilder sb = new StringBuilder("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám\n");
        int counter = 0;
        for (Citizen actualCitizen : citizens) {
            LocalTime vaccinationTime = firstVaccination.plusMinutes(30 * counter);
            sb.append(vaccinationTime.toString()).append(";");
            sb.append(actualCitizen.toShortString()).append("\n");
            counter++;
        }
        bw.write(sb.toString());
    }

    public boolean hasRegistration(String tajStr){
        try{
            int id = dao.existCitizenToTaj(tajStr);
        } catch (IndexOutOfBoundsException e){
            throw new IllegalArgumentException("Nincs regisztráció a megadott TAJ számmal.");
        }
        return true;
    }


    public void report(){
        List<String> data = dao.report();
        writeReportFile(data);
    }

    private void writeReportFile(List<String> data) {
        String header = "IRSZ;oltások száma;személyek száma";
        Path filePath = Path.of("d:", "covid", "report.txt");
        try (BufferedWriter bw = Files.newBufferedWriter(filePath)) {
            bw.write(header +"\n");
            for (String s : data) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException ex) {
            throw new IllegalStateException("Cannot write file", ex);
        }
    }

}
