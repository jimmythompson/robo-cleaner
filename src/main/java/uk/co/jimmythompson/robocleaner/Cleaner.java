package uk.co.jimmythompson.robocleaner;

import uk.co.jimmythompson.robocleaner.geometry.Coordinate;

import java.util.Observable;

public class Cleaner extends Observable {
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

    public Coordinate projectMovement(Direction direction) {
        return this.location.translate(direction.getTranslation());
    }

    public Coordinate move(Direction direction) {
        Coordinate newLocation = this.location.translate(direction.getTranslation());

        this.location = newLocation;

        this.setChanged();
        this.notifyObservers(newLocation);

        return newLocation;
    }
}
