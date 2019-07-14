package uk.co.jimmythompson.robocleaner;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.verify;

public class CleanerPilotTests {
    @Test
    public void navigateShouldDirectTheCleaner() {
        Cleaner mockCleaner = Mockito.mock(Cleaner.class);
        CleanerPilot pilot = new CleanerPilot(mockCleaner);

        pilot.navigate(Arrays.asList(Direction.NORTH, Direction.EAST));

        verify(mockCleaner).moveNorth();
        verify(mockCleaner).moveEast();
    }
}
