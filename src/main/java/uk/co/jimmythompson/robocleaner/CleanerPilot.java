package uk.co.jimmythompson.robocleaner;

import uk.co.jimmythompson.robocleaner.geometry.Area;
import uk.co.jimmythompson.robocleaner.geometry.Coordinate;

public class CleanerPilot {
    private Area area;
    private Cleaner cleaner;

    public CleanerPilot(Area area, Cleaner cleaner) {
        this.area = area;
        this.cleaner = cleaner;
    }

    public void navigate(Iterable<Direction> route) {
        for (Direction direction: route) {
            if (!this.isValidMovement(direction)) {
                throw new InvalidRouteException();
            }

            this.cleaner.move(direction);
        }
    }

    private boolean isValidMovement(Direction direction) {
        Coordinate newLocation = this.cleaner.projectMovement(direction);
        return this.area.contains(newLocation);
    }
}
