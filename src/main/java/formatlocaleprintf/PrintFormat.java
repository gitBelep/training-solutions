package formatlocaleprintf;

import java.util.Locale;

public class PrintFormat {

    public String formatMessageWithIntegerParameters(String formatString, Integer i, Integer j){
        try {
            return String.format(formatString, i, j);
        } catch (IllegalArgumentException ia){
            throw new IllegalArgumentException("Less objects then expected in format String!");
        }
    }

    public String printFormattedText(Double number){
        return String.format(new Locale("hu", "HU"),"Total is: %,.2f Ft",number);
    }
    public String printFormattedText(int count, String fruit){
        return String.format(new Locale("hu", "HU"),"We counted %d %s in the basket",count,fruit);
    }
    public String printFormattedText(int number){
        return String.format("Right edge of numbers set at 4 spaces from text:%4d", number);
    }
    public String printFormattedText(Integer i, Integer j, Integer k){
        return String.format("Multiple objects containing text:%d\t%d\t%d",i,j,k);
    }
}
