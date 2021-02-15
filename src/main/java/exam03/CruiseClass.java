package exam03;

public enum CruiseClass {
    LUXURY(3.0), FIRST(1.8), SECOND(1.0);

    final double extra;

    CruiseClass(double extra) {
        this.extra = extra;
    }
}
