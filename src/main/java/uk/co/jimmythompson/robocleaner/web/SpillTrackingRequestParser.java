package uk.co.jimmythompson.robocleaner.web;

import uk.co.jimmythompson.robocleaner.Direction;
import uk.co.jimmythompson.robocleaner.OilPatch;
import uk.co.jimmythompson.robocleaner.RouteParser;
import uk.co.jimmythompson.robocleaner.geometry.Area;
import uk.co.jimmythompson.robocleaner.geometry.Coordinate;

import java.util.List;
import java.util.stream.Collectors;

public class SpillTrackingRequestParser {
    private final SpillTrackingRequest request;

    private static Coordinate parseCoordinate(List<Integer> unparsed) {
        return new Coordinate(unparsed.get(0), unparsed.get(1));
    }

    public SpillTrackingRequestParser(SpillTrackingRequest request) {
        this.request = request;
    }

    public Area getArea() {
        Coordinate topRight = parseCoordinate(this.request.getAreaSize());
        return new Area(topRight);
    }

    public Coordinate getStartingPosition() {
        return parseCoordinate(this.request.getStartingPosition());
    }

    public List<OilPatch> getOilPatches() {
        return this.request.getOilPatches().stream()
                .map(SpillTrackingRequestParser::parseCoordinate)
                .map(OilPatch::new)
                .collect(Collectors.toList());
    }

    public List<Direction> getRoute() {
        return RouteParser.parseRoute(this.request.getNavigationInstructions());
    }
}
