package uk.co.jimmythompson.robocleaner;

public class Cleaner {
    private Coordinate location;

    private static Translation NORTH_TRANSLATION = new Translation(0, 1);
    private static Translation EAST_TRANSLATION = new Translation(1, 0);
    private static Translation SOUTH_TRANSLATION = new Translation(0, -1);
    private static Translation WEST_TRANSLATION = new Translation(-1, 0);

    public static Cleaner deploy(Coordinate startingLocation) {
        return new Cleaner(startingLocation);
    }

    private Cleaner(Coordinate startingLocation) {
        this.location = startingLocation;
    }

    public Coordinate getLocation() {
        return this.location;
    }

    public void moveNorth() {
        this.location = this.location.translate(NORTH_TRANSLATION);
    }

    public void moveEast() {
        this.location = this.location.translate(EAST_TRANSLATION);
    }

    public void moveSouth() {
        this.location = this.location.translate(SOUTH_TRANSLATION);
    }

    public void moveWest() {
        this.location = this.location.translate(WEST_TRANSLATION);
    }
}
