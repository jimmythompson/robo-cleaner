package uk.co.jimmythompson.robocleaner;

public enum Direction {
    NORTH(Translation.of(0, 1)),
    EAST(Translation.of(1, 0)),
    SOUTH(Translation.of(0, -1)),
    WEST(Translation.of(-1, 0));

    private Translation translation;

    Direction(Translation translation) {
        this.translation = translation;
    }

    public Translation getTranslation() {
        return translation;
    }

    public static Direction fromString(String code) {
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
