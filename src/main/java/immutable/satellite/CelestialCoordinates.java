package immutable.satellite;

public class CelestialCoordinates {
    private final int coordinateX;
    private final int coordinateY;
    private final int coordinateZ;

    public CelestialCoordinates(int coordinateX, int coordinateY, int coordinateZ) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.coordinateZ = coordinateZ;
    }

    @Override
    public String toString() {
        String s = String.format("CelestialCoordinates: x=%s, y=%s, z=%s", coordinateX, coordinateY, coordinateZ);
        return s;
    }

    public int getCoordinateX() {
        return coordinateX;
    }
    public int getCoordinateY() {
        return coordinateY;
    }
    public int getCoordinateZ() {
        return coordinateZ;
    }
}
