package uk.co.jimmythompson.robocleaner.geometry;

import org.junit.Assert;
import org.junit.Test;

public class AreaTests {
    private static Area area = new Area(new Coordinate(5, 5));

    @Test
    public void containsShouldReturnTrueWhenCoordinatesWithinBoundary() {
        Coordinate coordinate = new Coordinate(3, 2);

        Assert.assertTrue(area.contains(coordinate));
    }

    @Test
    public void containsShouldReturnFalseWhenXCoordinateTooLow() {
        Coordinate coordinate = new Coordinate(-1, 2);

        Assert.assertFalse(area.contains(coordinate));
    }

    @Test
    public void containsShouldReturnFalseWhenXCoordinateTooHigh() {
        Coordinate coordinate = new Coordinate(7, 2);

        Assert.assertFalse(area.contains(coordinate));
    }

    @Test
    public void containsShouldReturnFalseWhenYCoordinateTooLow() {
        Coordinate coordinate = new Coordinate(3, -1);

        Assert.assertFalse(area.contains(coordinate));
    }

    @Test
    public void containsShouldReturnFalseWhenYCoordinateTooHigh() {
        Coordinate coordinate = new Coordinate(3, 7);

        Assert.assertFalse(area.contains(coordinate));
    }
}