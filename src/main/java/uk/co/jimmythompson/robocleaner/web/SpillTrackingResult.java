package uk.co.jimmythompson.robocleaner.web;

import uk.co.jimmythompson.robocleaner.geometry.Coordinate;

import java.util.List;

import static java.util.Arrays.asList;

public class SpillTrackingResult {
    private List<Integer> finalPosition;
    private Integer oilPatchesCleaned;

    private static List<Integer> coordinateToList(Coordinate coordinate) {
        return asList(coordinate.getX(), coordinate.getY());
    }

    public SpillTrackingResult(Coordinate finalPosition, int oilPatchesCleaned) {
        this.finalPosition = coordinateToList(finalPosition);
        this.oilPatchesCleaned = oilPatchesCleaned;
    }

    public List<Integer> getFinalPosition() {
        return finalPosition;
    }

    public Integer getOilPatchesCleaned() {
        return oilPatchesCleaned;
    }
}
