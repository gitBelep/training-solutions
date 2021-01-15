package activity;
import java.util.ArrayList;
import java.util.List;

public class Activities {
    private final List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public List<Report> distancesByTypesOldVersionByMe(){
        List<Report> distancesToType = new ArrayList<>();
        double sumDistance = 0;
        for (ActivityType a : ActivityType.values()){
            for (Activity ac : activities) {
                if (ac.getType() == a) {
                    sumDistance += ac.getDistance();
                }
            }
            distancesToType.add(new Report(a, sumDistance));
        }
        return distancesToType;
    }

    public List<Report> distancesByTypes(){
        double[] sum = new double[ActivityType.values().length];
        for (Activity ac : activities){
            sum[ac.getType().ordinal()] += ac.getDistance();
        }

        List<Report> result = new ArrayList<>();
        for (ActivityType act : ActivityType.values()){
            result.add(new Report(act, sum[act.ordinal()]));
        }
        return result;
    }

    public int numberOfTrackActivities() {
        int sum = 0;
        for (Activity a : activities) {
            if (a instanceof ActivityWithTrack) {
                sum++;
            }
        }
        return sum;
    }

    public int numberOfWithoutTrackActivities() {
        int sum = 0;
        for (Activity a : activities) {
            if (a instanceof ActivityWithoutTrack) {
                sum++;
            }
        }
        return sum;
    }

}
