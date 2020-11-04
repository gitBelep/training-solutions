package array;

public class ArrayMain {
    public static void main(String[] args) {
        String [] week= {"Hétfő", "Kedd", "Szerda", "Csüt", "Péntek", "Szombat", "Vasárnap"};
        System.out.println(week[1] +" "+ week.length);

        int[] power = new int[5];
        for (int i=0; i<power.length; i++){
            if (i ==0){
                power[i]=2;
            }else {
                power[i] = power[i - 1] * 2;
            }
            System.out.print(power[i] + ", ");
        }
        System.out.println();

        boolean[] b = {false, true, false, true, false, true};
        for (boolean i: b){
            System.out.print(i + ", ");
        }
    }
}
