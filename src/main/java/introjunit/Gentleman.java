package introjunit;

public class Gentleman {

    public String sayHello(String name){
        if ( name == null){
            return "Hello Anonymous";
        }else{
            return "Hello "+ name;
        }
    }

    public static void main(String[] args) {
        Gentleman gm = new Gentleman();
        String JohnNull = null;
        System.out.println(gm.sayHello("John Doe"));
        System.out.println(gm.sayHello(JohnNull));
    }
}
