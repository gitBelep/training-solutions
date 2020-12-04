package defaultconstructor.date;

public class SimpleDateFormatter {
    private static CountryCode defaultCc;

    public SimpleDateFormatter(){
        this.defaultCc = CountryCode.HU;
    }

    public static String formatDateStringByCountryCode(CountryCode cc, SimpleDate d){
        String s ="";
        switch (cc){
            case US:
                s = String.format("%d-%d-%d",d.getMonth(),d.getDay(),d.getYear());
                break;
            case EN:
                s = String.format("%d-%d-%d",d.getDay(),d.getMonth(),d.getYear());
                break;
            case HU:
                s = String.format("%d-%d-%d",d.getYear(),d.getMonth(),d.getDay());
                break;
        }
        return s;
    }

    public static String formatDateString(SimpleDate d){
        return formatDateStringByCountryCode(defaultCc, d);
    }

}
