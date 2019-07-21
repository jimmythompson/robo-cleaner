package uk.co.jimmythompson.robocleaner;

import uk.co.jimmythompson.robocleaner.geometry.Coordinate;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class SpillTracker implements Observer {

    private final List<OilPatch> oilPatches;

    public SpillTracker(List<OilPatch> oilPatches) {
        this.oilPatches = oilPatches;
    }

    public List<OilPatch> getOilPatches() {
        return oilPatches;
    }

    public void track(Cleaner cleaner) {
        cleaner.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        Coordinate cleanedLocation = (Coordinate) arg;

        for (OilPatch oilPatch : this.oilPatches) {
            if (oilPatch.getLocation().equals(cleanedLocation)) {
                oilPatch.markAsCleaned();
            }
        }
    }
}
