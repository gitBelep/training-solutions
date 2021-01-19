package week12d02;

public class Site {
    private final boolean sideEven;
    private final int length;
    private final FenceType fenceType;

    public Site(boolean sideEven, int length, FenceType fenceType) {
        this.sideEven = sideEven;
        this.length = length;
        this.fenceType = fenceType;
    }

    public boolean isSideEven() {
        return sideEven;
    }

    public int getLength() {
        return length;
    }

    public FenceType getFenceType() {
        return fenceType;
    }
}