import java.util.Arrays;

/**
 * @author alevochkin.
 */
public class Brute {
    private static final String POINT_SEPARATOR = "->";

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new RuntimeException("Please enter input file");
        }
        In in = new In(args[0]);
        Point[] points = new Point[in.readInt()];

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        for (int i = 0; i < points.length; i++) {
            Point point = new Point(in.readInt(), in.readInt());
            points[i] = point;
            point.draw();
        }

        for (int p = 0; p < points.length; p++) {
            for (int q = p + 1; q < points.length; q++) {
                double slopeToQ = points[p].slopeTo(points[q]);
                for (int r = q + 1; r < points.length; r++) {
                    if (slopeToQ == points[p].slopeTo(points[r])) {
                        for (int s = r + 1; s < points.length; s++) {
                            if (slopeToQ == points[p].slopeTo(points[s])) {
                                printLine(new Point[] {points[p], points[q], points[r], points[s]});
                            }
                        }
                    }
                }
            }
        }
    }

    private static void printLine(Point[] line) {
        Arrays.sort(line);
        StringBuilder builder = new StringBuilder();
        for (Point point : line) {
            builder.append(point);
            builder.append(POINT_SEPARATOR);
        }
        builder.setLength(builder.length() - POINT_SEPARATOR.length());
        StdOut.println(builder.toString());
        line[0].drawTo(line[3]);
    }
}
