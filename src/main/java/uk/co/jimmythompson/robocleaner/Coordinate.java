package uk.co.jimmythompson.robocleaner;

import java.util.Objects;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Coordinate translate(Translation translation) {
        int newX = this.x + translation.getX();
        int newY = this.y + translation.getY();

        return new Coordinate(newX, newY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        Coordinate other = (Coordinate) o;

        return Objects.equals(this.x, other.x)
                && Objects.equals(this.y, other.y);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
