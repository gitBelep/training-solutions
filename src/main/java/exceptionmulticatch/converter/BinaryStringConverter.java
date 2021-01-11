package exceptionmulticatch.converter;
import java.util.ArrayList;
import java.util.List;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String str) {
        if (str == null){
            throw new NullPointerException("binaryString null");
        }
        List<Character> allowedValues = new ArrayList<>(List.of('1','0'));
        for (int i = 0; i < str.length(); i++){
            if ( !allowedValues.contains(str.charAt(i)) ){
                throw new IllegalArgumentException("binaryString not valid");
            }
        }
        char[] charArray = str.toCharArray();
        boolean[] boo = new boolean[str.length()];
        for (int j = 0; j < str.length(); j++){
            if (charArray[j] == '1'){
                boo[j] = true;
            }
        }
        return  boo;
    }

    public String booleanArrayToBinaryString(boolean[] boo){
        if (boo == null || boo.length == 0){
            throw new IllegalArgumentException("Üres tömb");
        }
        StringBuilder result = new StringBuilder();
        for(boolean b : boo){
            if (b == true){
                result.append("1");
            } else {
                result.append("0");
            }
        }
        return result.toString();
    }

}
