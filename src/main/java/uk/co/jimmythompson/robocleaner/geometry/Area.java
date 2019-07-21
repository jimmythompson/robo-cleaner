package uk.co.jimmythompson.robocleaner.geometry;

public class Area {
    private static Coordinate bottomLeft = new Coordinate(0, 0);
    private Coordinate topRight;

    public Area(Coordinate topRight) {
        this.topRight = topRight;
    }

    public boolean contains(Coordinate coordinate) {
        return coordinate.getX() >= bottomLeft.getX()
                && coordinate.getX() <= topRight.getX()
                && coordinate.getY() >= bottomLeft.getY()
                && coordinate.getY() <= topRight.getY();
    }
}
