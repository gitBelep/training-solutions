package properties;

import java.io.*;
import java.util.Properties;

public class DatabaseConfiguration {
    private Properties p = new Properties();

    public DatabaseConfiguration(){
       try (InputStream ins = DatabaseConfiguration.class.getResourceAsStream("/db.properties")){
           InputStreamReader inr = new InputStreamReader(ins, "UTF-8");
//InputStreamReader csak a filekódolás miatt kell. "p.load(ins);" is működik.
           p.load(inr);
           inr.close();
       } catch (IOException e){
           throw new IllegalArgumentException("Cannot read file", e);
       }
    }

    public DatabaseConfiguration(File file){
        try (FileReader r = new FileReader(file)) {
            p.load(r);
        } catch (IOException e){
            throw new IllegalArgumentException("Cannot read file", e);
        }
    }

    public String getHost(){
        System.out.println(p);
        return p.getProperty("db.host", "hibás olvasás");
    }

    public int getPort(){
        return Integer.parseInt(p.getProperty("db.port"));
    }

    public String getSchema(){
        return p.getProperty("db.schema");
    }

}
