package operators;

public class OperatorsMain {
    public static void main(String[] args) {
        int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        int j = Long.valueOf(s, 2).intValue();
        System.out.println(j +" sacc: túl sok karakterből állt");

        System.out.println(0333 +" Nyolcas számrendszerbeli");

    }
}
