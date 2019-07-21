package uk.co.jimmythompson.robocleaner;

import org.junit.Assert;
import org.junit.Test;
import uk.co.jimmythompson.robocleaner.geometry.Coordinate;

public class OilPatchTests {
    @Test
    public void getLocationShouldReturnLocation() {
        Coordinate location = new Coordinate(1, 1);
        OilPatch oilPatch = new OilPatch(location);

        Assert.assertEquals(location, oilPatch.getLocation());
    }

    @Test
    public void hasBeenCleanedShouldBeginAsFalse() {
        Coordinate location = new Coordinate(1, 1);
        OilPatch oilPatch = new OilPatch(location);

        Assert.assertFalse(oilPatch.hasBeenCleaned());
    }

    @Test
    public void markAsCleanedShouldMarkThePatchAsCleaned() {
        Coordinate location = new Coordinate(1, 1);
        OilPatch oilPatch = new OilPatch(location);

        oilPatch.markAsCleaned();

        Assert.assertTrue(oilPatch.hasBeenCleaned());
    }
}
