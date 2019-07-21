package uk.co.jimmythompson.robocleaner;

public class SpillStatus {
    private final int totalPatches;
    private final int cleanedPatches;

    public SpillStatus(int totalPatches, int cleanedPatches) {
        this.totalPatches = totalPatches;
        this.cleanedPatches = cleanedPatches;
    }

    public int getTotalPatches() {
        return this.totalPatches;
    }

    public int getCleanedPatches() {
        return cleanedPatches;
    }
}
