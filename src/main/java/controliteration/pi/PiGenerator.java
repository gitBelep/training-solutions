package controliteration.pi;

import java.util.ArrayList;
import java.util.List;

public class PiGenerator {
    private String vers;

    public PiGenerator(String vers){
        this.vers = vers;
    }

    public String getPi(){
        List<Integer> szamJegyek = new ArrayList<>();
        szamJegyek.add(-1);
        List<Character> abc = new ArrayList<>();
        abc = List.of('á', 'é', 'í', 'ó', 'ö', 'ő', 'ú', 'ü', 'ű','a', 'b', 'c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
        char c;

        for (int i =0; i<vers.length(); i++){
            c = vers.toLowerCase().charAt(i);
            if (!abc.contains( (Character) c) ) {
                szamJegyek.add(i);
            }
        }

        List<Integer> kulonbsegek = new ArrayList<>();
        int k;
        String pii = new String();
        Integer km;

        for (int i =1; i<szamJegyek.size(); i++){
            k = szamJegyek.get(i) - szamJegyek.get(i-1);
            if (k > 1) {
                km = k-1;
                pii = pii.concat(km.toString());
            }
        }
        return pii.substring(0,1) +"."+ pii.substring(1);
    }

    public static void main(String[] args) {
        String versPirol = "Nem a, régi s durva közelítés, mi szótól szóig így kijön betűiket számlálva. Ludolph eredménye már, ha itt végezzük húsz jegyen. \n" +
                "De rendre kijő még tíz pontosan. Azt is bízvást ígérhetem.";
        PiGenerator piVers = new PiGenerator(versPirol);
        System.out.println(piVers.getPi());
    }
}
