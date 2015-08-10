/*************************************************************************
 * Name:
 * Email:
 * <p/>
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 * <p/>
 * Description: An immutable data type for points in the plane.
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {
        @Override
        public int compare(Point point1, Point point2) {
            return (int) (slopeTo(point1) - slopeTo(point2));
        }
    };

    /**
     * x coordinate
     */
    private final int x;
    /**
     * y coordinate
     */
    private final int y;

    /**
     * create the point (x, y)
     */
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    /**
     * plot this point to standard drawing
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    /**
     * draw line between this point and that point to standard drawing
     *
     * @param that second point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and point point
    public double slopeTo(Point point) {
        return ((double) (y - point.y)) / (x - point.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point point) {
        assert point != null;
        int result = y - point.y;
        if (result == 0) {
            result = x - point.x;
        }
        return result;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // compare points by slope
    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}