package uk.co.jimmythompson.robocleaner;

import org.junit.Assert;
import org.junit.Test;

public class CleanerTests {
    @Test
    public void getLocationShouldReturnLocation() {
        Coordinate startingLocation = new Coordinate(1, 1);
        Cleaner cleaner = Cleaner.deploy(startingLocation);
        Assert.assertEquals(startingLocation, cleaner.getLocation());
    }

    @Test
    public void moveNorthShouldUpdateTheLocation() {
        Coordinate startingLocation = new Coordinate(1, 1);
        Coordinate expectedLocation = new Coordinate(1, 2);
        Cleaner cleaner = Cleaner.deploy(startingLocation);

        cleaner.moveNorth();

        Assert.assertEquals(expectedLocation, cleaner.getLocation());
    }

    @Test
    public void moveEastShouldUpdateTheLocation() {
        Coordinate startingLocation = new Coordinate(1, 1);
        Coordinate expectedLocation = new Coordinate(2, 1);
        Cleaner cleaner = Cleaner.deploy(startingLocation);

        cleaner.moveEast();

        Assert.assertEquals(expectedLocation, cleaner.getLocation());
    }

    @Test
    public void moveSouthShouldUpdateTheLocation() {
        Coordinate startingLocation = new Coordinate(1, 1);
        Coordinate expectedLocation = new Coordinate(1, 0);
        Cleaner cleaner = Cleaner.deploy(startingLocation);

        cleaner.moveSouth();

        Assert.assertEquals(expectedLocation, cleaner.getLocation());
    }

    @Test
    public void moveWestShouldUpdateTheLocation() {
        Coordinate startingLocation = new Coordinate(1, 1);
        Coordinate expectedLocation = new Coordinate(0, 1);
        Cleaner cleaner = Cleaner.deploy(startingLocation);

        cleaner.moveWest();

        Assert.assertEquals(expectedLocation, cleaner.getLocation());
    }
}
