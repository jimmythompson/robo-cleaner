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
}
