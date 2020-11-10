package primitivetypes;

public class PrimitiveTypes {

    public static void main(String[] args) {
        int a = 5;
        Integer b = 3;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(new Integer(1) + new Integer(2));
        Integer i =7;
        Integer k= 5;
        System.out.println(i+k);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE-Integer.MIN_VALUE);
        System.out.println(Double.NEGATIVE_INFINITY );
    }
}
