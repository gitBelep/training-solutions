package ioprintwriter.salary;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SalaryWriter {
    private final List<String> names;

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path path){
        try (PrintWriter wr = new PrintWriter(Files.newBufferedWriter(path))){
            for (String str : names){
                if (str.substring(0,4).equals("Dr. ")){
                    writeDr(wr,str);
                } else if (str.substring(0,4).equals("Mr. ") || str.substring(0,4).equals("Mrs.")){
                    writeMrOrMrs(wr,str);
                } else{
                    writeNameWithoutSign(wr,str);
                }
            }
        } catch (IOException e){
            throw new IllegalStateException("Writing is not possible", e);
        }
    }

    private void writeDr(PrintWriter wr, String name){
        wr.print(name +": ");
        wr.println(500000);
    }

    private void writeMrOrMrs(PrintWriter wr, String name){
        wr.print(name +": ");
        wr.println(200000);
    }

    private void writeNameWithoutSign(PrintWriter wr, String name){
        wr.print(name +": ");
        wr.println(100000);
    }

}
