package enumtype.week;

public enum Day {
    HÉTFŐ(DayType.WORKDAY), KEDD(DayType.WORKDAY), SZERDA(DayType.WORKDAY), CSÜTÖRTÖK(DayType.WORKDAY), PÉNTEK(DayType.WORKDAY), SZOMBAT(DayType.HOLYDAY), VASÁRNAP(DayType.HOLYDAY);

    private final DayType dt;

    Day(DayType dt){
        this.dt = dt;
    }
    public DayType getDayType(){
        return dt;
    }
}
