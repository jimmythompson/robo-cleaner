package uk.co.jimmythompson.robocleaner;

import org.junit.Assert;
import org.junit.Test;
import uk.co.jimmythompson.robocleaner.geometry.Coordinate;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class SpillTrackerTests {
    @Test
    public void shouldHaveOilPatches() {
        Coordinate location = new Coordinate(1,1);
        OilPatch oilPatch = new OilPatch(location);
        SpillTracker spillTracker = new SpillTracker(singletonList(oilPatch));

        Assert.assertEquals(singletonList(oilPatch), spillTracker.getOilPatches());
    }

    @Test
    public void shouldMarkOilPatchesAsCleanWhenTheCleanerGoesOverThem() {
        Coordinate oilPatchLocation = new Coordinate(1,1);
        OilPatch oilPatch = new OilPatch(oilPatchLocation);
        SpillTracker spillTracker = new SpillTracker(singletonList(oilPatch));

        Coordinate cleanerLocation = new Coordinate(1, 0);
        Cleaner cleaner = Cleaner.deploy(cleanerLocation);

        Assert.assertFalse(oilPatch.hasBeenCleaned());

        spillTracker.follow(cleaner);
        cleaner.move(Direction.NORTH);

        Assert.assertTrue(oilPatch.hasBeenCleaned());
    }

    @Test
    public void getStatusShouldReturnTheNumberOfPatches() {
        Coordinate firstLocation = new Coordinate(1,1);
        OilPatch firstPatch = new OilPatch(firstLocation);

        Coordinate secondLocation = new Coordinate(2,2);
        OilPatch secondPatch = new OilPatch(secondLocation);

        Coordinate thirdLocation = new Coordinate(3,3);
        OilPatch thirdPatch = new OilPatch(thirdLocation);

        SpillTracker spillTracker = new SpillTracker(asList(firstPatch, secondPatch, thirdPatch));

        Assert.assertEquals(3, spillTracker.getStatus().getTotalPatches());
    }

    @Test
    public void getStatusShouldReturnTheNumberOfCleanedPatches() {
        Coordinate firstLocation = new Coordinate(1,1);
        OilPatch firstPatch = new OilPatch(firstLocation);

        Coordinate secondLocation = new Coordinate(2,2);
        OilPatch secondPatch = new OilPatch(secondLocation);

        Coordinate thirdLocation = new Coordinate(3,3);
        OilPatch thirdPatch = new OilPatch(thirdLocation);

        SpillTracker spillTracker = new SpillTracker(asList(firstPatch, secondPatch, thirdPatch));

        Coordinate cleanerLocation = new Coordinate(1, 0);
        Cleaner cleaner = Cleaner.deploy(cleanerLocation);

        spillTracker.follow(cleaner);
        cleaner.move(Direction.NORTH);

        Assert.assertEquals(1, spillTracker.getStatus().getCleanedPatches());
    }
}
