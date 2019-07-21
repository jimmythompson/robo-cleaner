package uk.co.jimmythompson.robocleaner.geometry;

public class Translation {
    private int x;
    private int y;

    public static Translation of(int x, int y) {
        return new Translation(x, y);
    }

    private Translation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
