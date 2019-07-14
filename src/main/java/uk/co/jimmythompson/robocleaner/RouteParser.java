package uk.co.jimmythompson.robocleaner;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;

public class RouteParser {
    public static List<Direction> parseRoute(String routeAsString) {
        List<Direction> route = new ArrayList<>();

        for (String letter : routeAsString.split("")) {
            route.add(fromString(letter));
        }

        return route;
    }

    private static Direction fromString(String code) {
        switch (code) {
            case "N":
                return Direction.NORTH;
            case "E":
                return Direction.EAST;
            case "S":
                return Direction.SOUTH;
            case "W":
                return Direction.WEST;
        }

        throw new InvalidDirectionException();
    }
}
