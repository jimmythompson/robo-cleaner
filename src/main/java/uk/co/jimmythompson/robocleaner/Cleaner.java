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


    public Coordinate move(Direction direction) {
        Coordinate newLocation = this.location.translate(direction.getTranslation());
        this.location = newLocation;
        return newLocation;
    }
}
