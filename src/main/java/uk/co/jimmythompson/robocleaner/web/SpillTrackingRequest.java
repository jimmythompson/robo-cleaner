package uk.co.jimmythompson.robocleaner.web;

import uk.co.jimmythompson.robocleaner.Direction;
import uk.co.jimmythompson.robocleaner.OilPatch;
import uk.co.jimmythompson.robocleaner.RouteParser;
import uk.co.jimmythompson.robocleaner.geometry.Area;
import uk.co.jimmythompson.robocleaner.geometry.Coordinate;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SpillTrackingRequest {
    private List<Integer> areaSize;
    private List<Integer> startingPosition;
    private List<List<Integer>> oilPatches;
    private String navigationInstructions;

    public SpillTrackingRequest() {
    }

    public List<Integer> getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(List<Integer> areaSize) {
        this.areaSize = areaSize;
    }

    public List<Integer> getStartingPosition() {
        return startingPosition;
    }

    public void setStartingPosition(List<Integer> startingPosition) {
        this.startingPosition = startingPosition;
    }

    public List<List<Integer>> getOilPatches() {
        return oilPatches;
    }

    public void setOilPatches(List<List<Integer>> oilPatches) {
        this.oilPatches = oilPatches;
    }

    public String getNavigationInstructions() {
        return navigationInstructions;
    }

    public void setNavigationInstructions(String navigationInstructions) {
        this.navigationInstructions = navigationInstructions;
    }
}
