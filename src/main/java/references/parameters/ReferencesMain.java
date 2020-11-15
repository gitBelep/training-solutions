package references.parameters;

public class ReferencesMain {
    public static void main(String[] args) {
        Person p1 = new Person("Anna", 31);
        Person p2 = new Person("Bell", 32);
        p1 = p2;
        p2 = p1;
        p2.setName("Jocó");
        System.out.println(p1.getName() +" "+ p2.getName());

        int a;
        int b;
        a = 24;
        b = a;
        b = b+1;
        System.out.println("a"+ a + " b"+ b);

        Person newP = new Person("Újfiú", 100);
        p1 = newP;
        System.out.println(p1.getName() +" p1, p2 "+ p2.getName() + ", new: " + newP.getName());


    }
}
