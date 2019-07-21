package uk.co.jimmythompson.robocleaner.geometry;

import org.junit.Assert;
import org.junit.Test;
import uk.co.jimmythompson.robocleaner.Translation;

public class CoordinateTests {
    @Test
    public void getXShouldReturnSpecifiedXCoordinate() {
        Coordinate coordinate = new Coordinate(1, 0);

        Assert.assertEquals(1, coordinate.getX());
    }

    @Test
    public void getYShouldReturnSpecifiedYCoordinate() {
        Coordinate coordinate = new Coordinate(0, 1);

        Assert.assertEquals(1, coordinate.getY());
    }

    @Test
    public void translateShouldApplyTranslations() {
        Coordinate coordinate = new Coordinate(0, 1);
        Translation translation = Translation.of(2, -1);
        Coordinate expectedResult = new Coordinate(2, 0);

        Assert.assertEquals(expectedResult, coordinate.translate(translation));
    }

    @Test
    public void equalsShouldReturnTrueIfObjectsAreTheSame() {
        Coordinate coordinate = new Coordinate(5, 5);

        Assert.assertEquals(coordinate, coordinate);
    }

    @Test
    public void equalsShouldReturnFalseIfTheOtherIsNull() {
        Coordinate coordinate = new Coordinate(3, 3);

        Assert.assertNotEquals(coordinate, null);
    }

    @Test
    public void equalsShouldReturnFalseIfTheTypesAreNotTheSame() {
        Coordinate coordinate = new Coordinate(2, 2);

        Assert.assertNotEquals(coordinate, new Object());
    }

    @Test
    public void equalsShouldReturnTrueIfXAndYAreTheSame() {
        Coordinate coordinate = new Coordinate(1, 1);
        Coordinate other = new Coordinate(1, 1);

        Assert.assertEquals(coordinate, other);
    }

    @Test
    public void toStringShouldShowXAndY() {
        Coordinate coordinate = new Coordinate(3, 2);

        Assert.assertEquals("Coordinate{x=3, y=2}", coordinate.toString());
    }
}
