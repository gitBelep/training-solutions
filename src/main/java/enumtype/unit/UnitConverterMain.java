package enumtype.unit;

public class UnitConverterMain {
    public static void main(String[] args) {
        UnitConverter uc = new UnitConverter();
        System.out.println(uc.convert(365.365,LengthUnit.FOOT,LengthUnit.CENTIMETER));
        System.out.println(uc.convert(365.365,LengthUnit.FOOT,LengthUnit.INCH));
        System.out.println(uc.convert(365.365,LengthUnit.FOOT,LengthUnit.YARD));
        System.out.println(uc.convert(365.365,LengthUnit.YARD,LengthUnit.CENTIMETER));
        System.out.println(uc.convert(365.365,LengthUnit.YARD,LengthUnit.INCH));
        System.out.println(uc.convert(365.365,LengthUnit.INCH,LengthUnit.METER));
        System.out.println(uc.convert(365.365,LengthUnit.METER,LengthUnit.MILLIMETER));
        System.out.println(uc.convert(365.365,LengthUnit.METER,LengthUnit.FOOT));

        System.out.println("SI mértékek: "+ uc.siUnits());

        System.out.print("Összes mértékegység: ");
        for (LengthUnit lll : LengthUnit.values()){
            System.out.print(lll +", ");
        }
    }
}
