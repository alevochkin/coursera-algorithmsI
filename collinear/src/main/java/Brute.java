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

        LinkedQueue<LinkedQueue<Point>> lines = new LinkedQueue<>();

        //StdDraw.setXscale(0, 32768);
        //StdDraw.setYscale(0, 32768);

        for (int i = 0; i < points.length - 1; i++) {
            LinkedQueue<Point> line = new LinkedQueue<>();
            Point p = points[i];
            points[i] = points[0];
            points[0] = p;
            for (int j = 1; j < points.length; j++) {
                Point q = points[j];
                double slope = p.slopeTo(q);
                line = new LinkedQueue<>();
                line.enqueue(p);
                line.enqueue(q);
                Point[] aux = new Point[points.length - 2];
                System.arraycopy(points, 2, aux, 0, aux.length);
                findLinePoints(p, slope, aux, line);
            }
            if (line.size() >= 4) {
                lines.enqueue(line);
            }
        }
        printLines(lines);
    }

    private static void findLinePoints(Point p, double slope, Point[] points, LinkedQueue<Point> line) {
        for (Point r : points) {
            if (slope == p.slopeTo(r)) {
                line.enqueue(r);
            }
        }
    }

    private static void printLines(LinkedQueue<LinkedQueue<Point>> lines) {
        StringBuilder builder = new StringBuilder();
        for (LinkedQueue<Point> line : lines) {
            for (Point point : line) {
                builder.append(point);
                builder.append("->");
            }
            builder.setLength(builder.length() - 2);
            StdOut.print(builder.toString());
            StdOut.println();
            builder.setLength(0);
        }
    }
}
