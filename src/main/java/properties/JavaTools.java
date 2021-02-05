package properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

public class JavaTools {
    Properties p = new Properties();

    public JavaTools(){
        try (InputStream ins = JavaTools.class.getResourceAsStream("/javatools.properties")) {
            InputStreamReader ir = new InputStreamReader(ins, "UTF-8");
            p.load(ir);
            ir.close();
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file", e);
        }
    }

    public Set<String> getToolKeys(){
        Set<String> keys = new HashSet<>();
        for (String s : p.stringPropertyNames()){
            keys.add(s.substring(0, s.indexOf(".")));
        }
        return keys;
    }

    public Set<String> getTools(){
        Set<String> tools = new TreeSet<>();
        for (String s : p.stringPropertyNames()){
            if (s.contains("name")) {
                tools.add(p.get(s).toString());
            }
        }
        return tools;
    }

    public String getName(String name){
        String result = "";
        for (String key : p.stringPropertyNames()){
            if (key.contains(name) && key.contains("name")){
                System.out.println(p.get(key).getClass());
                result = p.get(key).toString();
            }
        }
        return result;
    }

    public String getUrl(String name){
        String result = "";
        for (String key : p.stringPropertyNames()){
            if (key.contains(name) && key.contains("url")){
                result = p.get(key).toString();
            }
        }
        return result;
    }

}
