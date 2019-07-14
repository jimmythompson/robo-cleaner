package uk.co.jimmythompson.robocleaner;

public class Cleaner {
    private Coordinate location;

    public static Cleaner deploy(Coordinate startingLocation) {
        return new Cleaner(startingLocation);
    }

    private Cleaner(Coordinate startingLocation) {
        this.location = startingLocation;
    }

    public Coordinate getLocation() {
        return this.location;
    }

    public void move(Direction direction) {
        this.location = this.location.translate(direction.getTranslation());
    }
}
