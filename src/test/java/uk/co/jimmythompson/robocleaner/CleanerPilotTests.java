package uk.co.jimmythompson.robocleaner;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import uk.co.jimmythompson.robocleaner.geometry.Area;
import uk.co.jimmythompson.robocleaner.geometry.Coordinate;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CleanerPilotTests {
    @Test
    public void navigateShouldDirectTheCleaner() {
        Area mockArea = Mockito.mock(Area.class);
        Cleaner mockCleaner = Mockito.mock(Cleaner.class);
        CleanerPilot pilot = new CleanerPilot(mockArea, mockCleaner);

        pilot.navigate(asList(Direction.NORTH, Direction.EAST));

        Coordinate newLocation = new Coordinate(1, 1);
        when(mockCleaner.projectMovement(Direction.NORTH))
                .thenReturn(newLocation);
        when(mockArea.contains(newLocation)).thenReturn(true);

        verify(mockCleaner).move(Direction.NORTH);
        verify(mockCleaner).projectMovement(Direction.NORTH);
        verify(mockCleaner).move(Direction.EAST);
    }

    @Test(expected = InvalidRouteException.class)
    public void navigateShouldThrowAnExceptionWhenTheCleanerIsGoingToLeaveTheArea() {
        Area mockArea = Mockito.mock(Area.class);
        Cleaner mockCleaner = Mockito.mock(Cleaner.class);
        CleanerPilot pilot = new CleanerPilot(mockArea, mockCleaner);

        Coordinate newLocation = new Coordinate(1, 1);
        when(mockCleaner.projectMovement(Direction.NORTH))
                .thenReturn(newLocation);
        when(mockArea.contains(newLocation)).thenReturn(false);

        pilot.navigate(singletonList(Direction.NORTH));
    }
}
