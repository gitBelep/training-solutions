package stringmethods.filename;

public class FileNameManipulator {

    public char findLastCharacter(String file){
        if (file == null || "".equals(file.trim())){
            throw new IllegalArgumentException("Empty string!");
        }
        file = file.trim();
        char c = file.charAt(file.length()-1);
        return c;
    }

    public void testArg(String file){
        String pt = ".";
        if (file == null || "".equals(file.trim()) || !file.contains(".") || pt.equals(file.trim().substring(0,1))){
            throw new IllegalArgumentException("Invalid file name!");
        }
    }

    public String changeExtensionToLowerCase(String file){
        String pt = ".";
        if (file == null || "".equals(file.trim())){
            throw new IllegalArgumentException("Empty string!");
        }
        if (!file.contains(".") || pt.equals(file.trim().substring(0,1))){
            throw new IllegalArgumentException("Invalid argument!");
        }
        String newExt = findFileExtension(file).toLowerCase();
        String newFile = file.substring(0,file.length()-newExt.length());
        System.out.println(newExt);
        return newFile.concat(newExt);
    }

    public String findFileExtension(String file){
        testArg(file);
        StringBuilder sb = new StringBuilder(file);
        String str = sb.reverse().toString();
        int i = str.indexOf(".");
        String ext = file.substring( file.length()-(i+1), file.length());
        return ext;
    }
    public boolean identifyFilesByExtension(String part, String file){
        return false;
    }
    public boolean compareFilesByName(String part, String name){
        return false;
    }
    public String replaceStringPart(String part,String ext, String file){
        String str = null;
        return str;
    }



}
