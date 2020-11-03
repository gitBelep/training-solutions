package stringtype;

public class StringTypeMain {
    public static void main(String[] args) {
        String prefix = "Hello ";
        String name = "John Doe";
        String message = prefix + name;
        message = message + 444;
        boolean b = "Hello John Doe".equals(message);
        boolean c = message.equals("Hello John Doe444");
        String d ="";
        String g ="";
        int hossz = (d+g).length();
        System.out.println(b+" "+c+" "+hossz);
        String abc ="Abcde";
        System.out.println(abc.length());
        System.out.println(abc.substring(0,1)+", "+abc.substring(2,3));
        System.out.println(abc.substring(0,3));
    }
}
