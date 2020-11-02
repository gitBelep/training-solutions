package localvariables;

public class LocalVariables {

    public static void main(String[] args) {
        boolean b;
        b=false;
        System.out.println(b + ", értékadás ELŐTT nem sikerült használni (se primitívet, se Stringet)");
        int a =2;
        int i=3, j=4;
        System.out.println("i="+i+" j="+j);
        boolean r=true, f=false, h=true;
        System.out.println(r + ""+f +h); //sout miatt kell ""
        int k=i;
        String s ="Hello World";
        String t =s;
        {
            int x=0;
            System.out.println("s+k+t: " +s +" " +k +" " +t);
        }

        System.out.println(knowIksz());
    }

    public static String knowIksz(){
        int x =7;
        String text = "fg meghívható a leírásnál feljebb is " + x;
        return text;
    }

}
