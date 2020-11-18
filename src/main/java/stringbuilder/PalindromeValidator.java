package stringbuilder;

public class PalindromeValidator {

    public boolean isPalindrome(String pali){
        if (pali == null){
            throw new IllegalArgumentException("Text must not be null!");
        }
        pali = pali.trim().toLowerCase();
        StringBuilder sb = new StringBuilder(pali);
        String rev = sb.reverse().toString();
        return rev.equals(pali);
    }
}
