package week12d02;

public class SiteStatistic {
    private int count;
    private final FenceType fenceType;

    public SiteStatistic(FenceType fenceType) {
        this.count = 1;
        this.fenceType = fenceType;
    }

    public void increaseCount() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public FenceType getFence() {
        return fenceType;
    }
}
