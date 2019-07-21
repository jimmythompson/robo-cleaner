package uk.co.jimmythompson.robocleaner.cleaning;

import org.junit.Assert;
import org.junit.Test;

public class SpillStatusTests {
    @Test
    public void shouldHaveTheTotalNumberOfPatches() {
        SpillStatus spillStatus = new SpillStatus(1, 2);
        Assert.assertEquals(1, spillStatus.getTotalPatches());
    }

    @Test
    public void shouldHaveTheNumberOfCleanedPatches() {
        SpillStatus spillStatus = new SpillStatus(1, 2);
        Assert.assertEquals(2, spillStatus.getCleanedPatches());
    }
}
