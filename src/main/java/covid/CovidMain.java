package covid;

import java.util.*;

public class CovidMain {
    private static boolean QUIT = false;
    private static Scanner sc = new Scanner(System.in);
    private Validation validation = new Validation();
    private Covid covid = new Covid();
    private String generatedFileName = "";
    private CitizenDao dao = new CitizenDao();

    public static void main(String[] args) {
        CovidMain covid2021 = new CovidMain();
        while (!QUIT) {
            covid2021.menu();
            covid2021.choseMenu(sc.nextLine().toUpperCase());
        }
    }

    public void menu() {
        System.out.println(
                        "MENÜ     *     *     *   Quit: \"Q\"\n" +
                        "1. Regisztráció\n" +
                        "2. Tömeges regisztráció\n" +
                        "3. Generálás\n" +
                        "4. Oltás\n" +
                        "5. Oltás meghiúsulás\n" +
                        "6. Riport\n"+
                        "7. Riport irányítószámhoz");
    }

    private void choseMenu(String str) {
        switch (str) {
            case "1" -> registration();
            case "2" -> massRegistration();
            case "3" -> generateNameList();
            case "4" -> vaccinate();
            case "5" -> failedVaccination();
            case "6" -> report();
            case "7" -> reportForOneZip();
            case "Q" -> {
                QUIT = true;
                System.out.println("Good bye!");
            }
            default -> System.out.println("Invalid key\n");
        }
    }

    public void registration() {
        try {
            String name = nameValidation();
            String zipCode = zipCodeValidation();
            System.out.println( dao.findCityToZip(zipCode).toString() );
            int age = ageValidation();
            String email = emailValidation();
            String numberTAJ = tajValidation();
            List<Citizen> citizens = new ArrayList<>();
            citizens.add(new Citizen(name, zipCode, age, email, numberTAJ, 0));
            dao.registerCitizen(citizens);
            System.out.println("Regisztráció megtörtént.\n");
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }

//Ötlet: Message.class létrehozása: akkor mindezek lenyomhatók a Validationsba
    private String nameValidation(){
        System.out.println("Kérem adja meg adatait!  Teljes név:");
        String name = sc.nextLine();
        return validation.nameIsValid(name);
    }

    private String zipCodeValidation(){
        System.out.println("Irányítószám:");
        String zipCode = sc.nextLine();
        return validation.isZipValid(zipCode);
    }

    private int ageValidation(){
        System.out.println("Életkor:");
        String ageString = sc.nextLine();
        return validation.getAge(ageString);
    }

    private String emailValidation(){
        System.out.println("E-mailcím először:");
        String email1 = sc.nextLine();
        System.out.println("E-mailcím másodszor:");
        String email2 = sc.nextLine();
        return validation.isEmailValid(email1, email2);
    }

    private String tajValidation(){
        System.out.println("TAJ szám:");
        return validation.isTajValid(sc.nextLine());
    }

    public void massRegistration() {
        System.out.println("Fájl helye:");
        String pathStr = sc.nextLine();
        try{
            covid.readMassRegistrationFile(pathStr);
            System.out.println("Tömeges regisztráció megtörtént.\n");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void generateNameList() {
        System.out.println("Irányítószám:");
        String zipStr = sc.nextLine();
        System.out.println("Mi legyen a fájl neve:");
        generatedFileName = sc.nextLine().trim();
        try{
            covid.selectCitizens(zipStr, generatedFileName);
            System.out.println("Fájl kész ~  d:/covid/"+ generatedFileName +" \n");
        } catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }

    public void vaccinate() {
        try{
            String tajStr = tajValidation();
            covid.hasRegistration(tajStr);
            String vaccinationTypeOrEmpty = dao.searchVaccinationType(tajStr);
            if (vaccinationTypeOrEmpty.length() > 0) {
                System.out.println(vaccinationTypeOrEmpty);
            }
            System.out.println("Oltóanyag típusa:");
            String type = sc.nextLine();
            dao.registerVaccination(tajStr, type);
            System.out.println("Oltás regisztrálva.\n");
        } catch (IllegalStateException | IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void failedVaccination() {
        try{
            String tajStr = tajValidation();
            covid.hasRegistration(tajStr);
            System.out.println("Meghiúsulás oka:");
            String note = sc.nextLine();
            dao.registerFailedVaccination(tajStr, note);
            System.out.println("Meghiúsulás feljegyezve\n");
        } catch (IllegalStateException | IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void reportForOneZip() {
        try {
            Map<Integer, Integer> table = dao.reportForOneZipCode(zipCodeValidation());
            System.out.println("Megkapott oltások száma: személyek száma  ");
            for (Map.Entry<Integer, Integer> m : table.entrySet()) {
                System.out.print(m.getKey() + " db:   " + m.getValue() + " személy \n");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void report(){
        try {
            covid.report();
            System.out.println("Riport kész: d:/covid/report.txt\n");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

}
