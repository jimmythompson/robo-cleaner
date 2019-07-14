package uk.co.jimmythompson.robocleaner;

public class CleanerPilot {
    private Cleaner cleaner;

    public CleanerPilot(Cleaner cleaner) {
        this.cleaner = cleaner;
    }

    public void navigate(Iterable<Direction> route) {
        for (Direction direction: route) {
            this.cleaner.move(direction);
        }
    }
}
