package introexception;

public class SsnValidator {

    public boolean isValidSsn(String ssNrStr){
        if (ssNrStr.length() != 9){
            return false;
        }
        //betűk
        try{
            if (Integer.parseInt(ssNrStr) < 0){
            }
        }catch (IllegalArgumentException ie) {
            return false;
        }

        int odd0 = Integer.parseInt(ssNrStr.substring(0,1));
        int even1 = Integer.parseInt(ssNrStr.substring(1,2));
        int odd2 = Integer.parseInt(ssNrStr.substring(2,3));
        int even3 = Integer.parseInt(ssNrStr.substring(3,4));
        int odd4 = Integer.parseInt(ssNrStr.substring(4,5));
        int even5 = Integer.parseInt(ssNrStr.substring(5,6));
        int odd6 = Integer.parseInt(ssNrStr.substring(6,7));
        int even7 = Integer.parseInt(ssNrStr.substring(7,8));
        int odd = 3*(odd0 + odd2 + odd4 +odd6);
        int even = 7*(even1 + even3 + even5 + even7);
        int sNr9 = (odd + even) % 10;
        if (!ssNrStr.substring(8).equals(Integer.toString(sNr9))){
            return false;
        }
        return true;
    }
}
