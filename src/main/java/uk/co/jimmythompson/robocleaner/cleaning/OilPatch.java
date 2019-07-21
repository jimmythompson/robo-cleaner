package uk.co.jimmythompson.robocleaner.cleaning;

import uk.co.jimmythompson.robocleaner.geometry.Coordinate;

public class OilPatch {
    private Coordinate location;
    private boolean hasBeenCleaned;

    public OilPatch(Coordinate location) {
        this.location = location;
        this.hasBeenCleaned = false;
    }

    public Coordinate getLocation() {
        return location;
    }

    public boolean hasBeenCleaned() {
        return this.hasBeenCleaned;
    }

    public void markAsCleaned() {
        this.hasBeenCleaned = true;
    }
}
