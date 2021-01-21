package week02d02;

import java.util.Scanner;

public class Phone {
        private String type;
        private int mem;

        public Phone(String type, int mem){
            this.type = type;
            this.mem = mem;
    }

    public String getType(){
            return type;
    }
    public int getMem(){
            return mem;
    }
    public void setType(String type){
            this.type = type;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {
        System.out.println("Típus?");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("mem?");
        int me = sc.nextInt();
        Phone phone1 = new Phone(str,me);
        sc.nextLine();

        System.out.println("Típus?");
        str = sc.nextLine();
        System.out.println("mem?");
        me = sc.nextInt();
        Phone phone2 = new Phone(str,me);

        System.out.println(phone1.getMem() + phone1.getType());
        System.out.println(phone2.getMem() + phone2.getType());

    }
}
