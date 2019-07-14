package uk.co.jimmythompson.robocleaner;

public class CleanerPilot {
    private Cleaner cleaner;

    public CleanerPilot(Cleaner cleaner) {
        this.cleaner = cleaner;
    }

    public void navigate(Iterable<Direction> route) {
        for (Direction direction: route) {
            switch (direction) {
                case NORTH:
                    this.cleaner.moveNorth();
                    break;
                case EAST:
                    this.cleaner.moveEast();
                    break;
                case SOUTH:
                    this.cleaner.moveSouth();
                    break;
                case WEST:
                    this.cleaner.moveWest();
                    break;
            }
        }
    }
}
