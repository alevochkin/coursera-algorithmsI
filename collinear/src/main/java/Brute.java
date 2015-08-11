import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author alevochkin.
 */
public class Brute {
    public static void main(String[] args) {
        if (args.length < 1) {
            throw new RuntimeException("Please enter inout file");
        }
        In in = new In(args[0]);
        int number = in.readInt();
        Point[] points = new Point[number];
        for (int i = 0; i < number; i++) {
            points[i] = new Point(in.readInt(), in.readInt());
        }

        List<List<Point>> lines = new LinkedList<>();

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        for (int i = 0; i < points.length - 1; i++) {
            List<Point> line = new LinkedList<>();
            Point p = points[i];
            points[i] = points[0];
            points[0] = p;
            for (int j = 1; j < points.length; j++) {
                Point q = points[j];
                double slope = p.slopeTo(q);
                line = new LinkedList<>();
                line.add(p);
                line.add(q);
                for (int k = 1; k < points.length; k++) {
                    if (k != j) {
                        Point r = points[k];
                        if (slope == p.slopeTo(r)) {
                            line.add(r);
                        }
                    }
                }
                addLineWithoutDuplicated(line, lines);
            }
            addLineWithoutDuplicated(line, lines);
        }
        printLines(lines);
    }

    private static void addLineWithoutDuplicated(List<Point> points, List<List<Point>> lines) {
        if (points.size() >= 4) {
            boolean contains = false;
            for (List<Point> line : lines) {
                contains = line.size() >= points.size() && containsItems(line, points);
                if (contains) {
                    break;
                }
            }
            if (!contains) {
                Collections.sort(points);
                lines.add(points);
            }
        }
    }

    private static <Item> boolean containsItems(List<Item> queue, List<Item> values) {
        for (Item item : values) {
            boolean containsValue = contains(queue, item);
            if (!containsValue) {
                return false;
            }
        }
        return true;
    }

    private static <Item> boolean contains(List<Item> queue, Item value) {
        for (Item item : queue) {
            if (value.equals(item)) {
                return true;
            }
        }
        return false;
    }

    private static void printLines(List<List<Point>> lines) {
        List<Point> pointsToDraw = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        for (List<Point> line : lines) {
            for (Point point : line) {
                builder.append(point);
                builder.append("->");
                if (!contains(pointsToDraw, point)) {
                    point.draw();
                    pointsToDraw.add(point);
                }
            }
            builder.setLength(builder.length() - 2);
            StdOut.print(builder.toString());
            StdOut.println();
            builder.setLength(0);
            line.get(0).drawTo(line.get(line.size() - 1));
        }
    }
}
