package week05d02;
import java.util.List;

public class ChangeLetter {

//1.módszer: újra felépítem karakterenként
    public String changeVowels(String str) {
        str = str.toLowerCase();
        List<Character> eng = List.of('a', 'e', 'i', 'o', 'u');
//Character[] newStr = new Character[str.length()]; ne:vesszővel lesznek elválasztva
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (eng.contains(str.charAt(i))) {
                newStr = newStr + "*";
            } else {
                newStr = newStr + Character.toString(str.charAt(i));
            }
        }
        return newStr;
    }

//2.módszer: Lecserélem
    public String changeVowels2(String str) {
        str = str.toLowerCase();
        char[] eng = {'a', 'e', 'i', 'o', 'u'};
        for (char c : eng) {
            str = str.replace(c, '*');
        }
    return str;
    }
}
