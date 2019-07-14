package uk.co.jimmythompson.robocleaner;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RouteParserTests {
    @Test
    public void shouldParseNAsNorth() {
        List<Direction> expectedList = Collections.singletonList(Direction.NORTH);
        Assert.assertEquals(expectedList, RouteParser.parseRoute("N"));
    }

    @Test
    public void shouldParseEAsEast() {
        List<Direction> expectedList = Collections.singletonList(Direction.EAST);
        Assert.assertEquals(expectedList, RouteParser.parseRoute("E"));
    }

    @Test
    public void shouldParseSAsSouth() {
        List<Direction> expectedList = Collections.singletonList(Direction.SOUTH);
        Assert.assertEquals(expectedList, RouteParser.parseRoute("S"));
    }

    @Test
    public void shouldParseWAsWest() {
        List<Direction> expectedList = Collections.singletonList(Direction.WEST);
        Assert.assertEquals(expectedList, RouteParser.parseRoute("W"));
    }

    @Test
    public void shouldBeAbleToComposeRoutes() {
        List<Direction> expectedList = Arrays.asList(
                Direction.NORTH,
                Direction.EAST,
                Direction.SOUTH,
                Direction.WEST
        );

        Assert.assertEquals(expectedList, RouteParser.parseRoute("NESW"));
    }
}
