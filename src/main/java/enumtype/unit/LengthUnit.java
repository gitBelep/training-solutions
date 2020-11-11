package enumtype.unit;

public enum LengthUnit {
    MILLIMETER(1,true), CENTIMETER(10,true),METER(1000,true), YARD(914.4,false), FOOT(304.8,false), INCH(25.4,false);

    final double inMm;
    final boolean si;

    LengthUnit(double inMm, boolean si){
        this.inMm = inMm;
        this.si = si;
    }
}
