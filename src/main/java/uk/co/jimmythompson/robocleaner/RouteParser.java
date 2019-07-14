package uk.co.jimmythompson.robocleaner;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;

public class RouteParser {
    public static List<Direction> parseRoute(String routeAsString) {
        List<Direction> route = new ArrayList<>();

        for (String letter : routeAsString.split("")) {
            route.add(Direction.fromString(letter));
        }

        return route;
    }
}
