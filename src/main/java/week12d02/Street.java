package week12d02;

import java.util.ArrayList;
import java.util.List;

public class Street {
    private List<Site> sites = new ArrayList<>();
    private List<SiteStatistic> statistics = new ArrayList<>();

    public void sellSite(Site site) {
        sites.add(site);
    }

    public int getLastHouseNr() {
        int evenCounter = 0;
        for (Site s : sites) {
            if (s.isSideEven()) {
                evenCounter++;
            }
        }
        if (sites.get(sites.size() - 1).isSideEven()) {
            return evenCounter * 2;
        } else {
            return (sites.size() - evenCounter) * 2 - 1;
        }
    }

    public List<SiteStatistic> makeStatistic() {
        boolean found = false;
        for (Site s : sites){
            for (SiteStatistic ss : statistics){
                if (ss.getFence() == s.getFenceType()) {
                    ss.increaseCount();
                    found = true;
                    break;
                }
            }
            if (!found) {
                statistics.add(new SiteStatistic(s.getFenceType()));
            }
            found = false;
        }
        return statistics;
    }

    public List<Site> getSites() {
        return new ArrayList<>(sites);
    }

    public List<SiteStatistic> getStatistics() {
        return new ArrayList<>(statistics);
    }
}
