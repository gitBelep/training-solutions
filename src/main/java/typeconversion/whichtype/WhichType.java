package typeconversion.whichtype;
import java.util.ArrayList;
import java.util.List;

public class WhichType {

    public List<Type> whichType(String s){
        long number = Long.parseLong(s);
        List<Type> ok = new ArrayList<>();
        for(int i=0; i<Type.values().length;i++) {
            if (Type.values()[i].getMin() <= number && number <= Type.values()[i].getMax()){
                // ok.add(Type.valueOf(Type.values()[i].name()));
                ok.add(Type.values()[i]);  //ez is Objektumok listája
            }
        }
        return ok;
    }

    public static void main(String[] args) {
        System.out.println("     7 ~ "+ new WhichType().whichType("7"));
        System.out.println("  7000 ~ "+ new WhichType().whichType("7000"));
        System.out.println("700000 ~ "+ new WhichType().whichType("700000"));
    }
}
