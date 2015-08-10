import java.util.Arrays;

/**
 * @author alevochkin.
 */
public class Fast {
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

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        LinkedQueue<LinkedQueue<Point>> lines = new LinkedQueue<>();
        for (int i = 0; i < points.length - 4; i++) {
            Point p = points[i];
            Point[] aux = Arrays.copyOf(points, points.length - 1);
            LinkedQueue<Point> line = new LinkedQueue<>();
            MergeX.sort(aux, p.SLOPE_ORDER);
            double slope = p.slopeTo(aux[0]);
            for (Point point : aux) {
                if (p.slopeTo(point) != slope) {
                    slope = p.slopeTo(point);
                    addLine(line, lines);
                    line = new LinkedQueue<>();
                }
                line.enqueue(point);
            }
            lines.enqueue(line);
            addLine(line, lines);
        }
    }

    private static void addLine(LinkedQueue<Point> points, LinkedQueue<LinkedQueue<Point>> lines) {
        if (points.size() >= 4) {
            for (LinkedQueue<Point> line : lines) {
                if (line.size() > points.size()) {
                    boolean contains = true;
                    for (Point p : points) {
                        contains = contains && contains(line, p);
                        if (!contains) {
                            lines.enqueue(line);
                            return;
                        }
                    }
                }
            }
        }
    }

    private static <Item> boolean contains(LinkedQueue<Item> queue, Item value) {
        for (Item item : queue) {
            if (value.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
