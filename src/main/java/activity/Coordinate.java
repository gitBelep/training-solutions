package activity;

public class Coordinate {
    private final double latitude;
    private final double longitude;

    public Coordinate(double latitude, double longitude) {
        if (latitude < -90 || 90 < latitude ){
            throw new IllegalArgumentException("Invalid Coordinate");
        }
        this.latitude = latitude;
        if (longitude < -180 || 180 < longitude ) {
            throw new IllegalArgumentException("Invalid Coordinate");
        }
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
