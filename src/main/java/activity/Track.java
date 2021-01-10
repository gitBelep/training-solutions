package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private final List<TrackPoint> trackPoints = new ArrayList<>();

    public double getRectangleArea(){
        double a = findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude();
        double b = findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude();
        return a*b;
    }

    public Coordinate findMinimumCoordinate(){
        double minimumLatitude = Double.MAX_VALUE;
        double minimumLongitude = Double.MAX_VALUE;
        for (TrackPoint t : trackPoints){
            if (t.getCoordinate().getLatitude() < minimumLatitude){
                minimumLatitude = t.getCoordinate().getLatitude();
            }
            if (t.getCoordinate().getLongitude() < minimumLongitude){
                minimumLongitude = t.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minimumLatitude, minimumLongitude);
    }

        public Coordinate findMaximumCoordinate(){
        double maximumLatitude = Double.MIN_VALUE;
        double maximumLongitude = Double.MIN_VALUE;
        for (TrackPoint t : trackPoints){
            if (t.getCoordinate().getLatitude() > maximumLatitude){
                maximumLatitude = t.getCoordinate().getLatitude();
            }
            if (t.getCoordinate().getLongitude() > maximumLongitude){
                maximumLongitude = t.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maximumLatitude, maximumLongitude);
    }

    public double getDistance() {
        boolean first = true;
        double sumDistance = 0;
        for (int i = 0; i < trackPoints.size(); i++) {
            if (!first) {
                sumDistance += trackPoints.get(i).getDistanceFrom(trackPoints.get(i-1));
            } else {
                first = false;
            }
        }
        return sumDistance;
    }

    public double getFullElevation() {
        boolean first = true;
        double priorElevation = 0;
        double sumElevation = 0;
        for (TrackPoint t : trackPoints) {
            if (!first) {
                if (priorElevation < t.getElevation()) {
                    sumElevation += t.getElevation() - priorElevation;
                }
            } else {
                first = false;
            }
            priorElevation = t.getElevation();
        }
        return sumElevation;
    }

    public double getFullDecrease() {
        boolean first = true;
        double priorHeight = 0;
        double sumDecrease = 0;
        for (TrackPoint t : trackPoints) {
            if (!first) {
                if (priorHeight > t.getElevation()) {
                    sumDecrease += priorHeight - t.getElevation();
                }
            } else {
                first = false;
            }
            priorHeight = t.getElevation();
        }
        return sumDecrease;
    }

    public void addTrackPoint(TrackPoint point){
        trackPoints.add(point);
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }
}
