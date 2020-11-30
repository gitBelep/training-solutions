package immutable.satellite;

public class Satellite {
    private CelestialCoordinates destination;
    private String id;

    public Satellite(CelestialCoordinates destination, String id) {
        isEmpty(id);
        this.destination = destination;
        this.id = id;
    }

    public void modifyDestination(CelestialCoordinates diff){
        destination = new CelestialCoordinates(
        destination.getCoordinateX() + diff.getCoordinateX(),
        destination.getCoordinateY() + diff.getCoordinateY(),
        destination.getCoordinateZ() + diff.getCoordinateZ());
    }

    @Override
    public String toString() {
        String s = String.format("%s: CelestialCoordinates: x=%s, y=%s, z=%s", id, destination.getCoordinateX(), destination.getCoordinateY(), destination.getCoordinateZ());
        return s;
    }

    private boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            throw new IllegalArgumentException("Register ident must not be empty!");
        }
        return false;
    }

    public String getId() {
        return id;
    }
}
