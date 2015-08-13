import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author alevochkin
 */
public class Fast {
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

        Arrays.sort(points);
        for (int i = 0; i < points.length; i++) {
            Point origin = points[i];
            int newLength = points.length - (i + 1);
            Point[] aux = new Point[newLength];
            System.arraycopy(points, i + 1, aux, 0, newLength);
            MergeX.sort(aux, origin.SLOPE_ORDER);

            for (int j = i + 1; j < points.length; j++) {
                double slope = origin.slopeTo(points[j]);
                List<Point> line = new ArrayList<>();
                line.add(origin);
                for (Point point : aux) {
                    if (origin.slopeTo(point) == slope) {
                        line.add(point);
                        j++;
                    } else {
                        Collections.sort(line);
                        if (line.size() >= 4) {
                            printLine(line);
                        }
                    }
                }
                Collections.sort(line);
                if (line.size() >= 4) {
                    printLine(line);
                }
            }

        }
    }

    private static void printLine(List<Point> line) {
            Collections.sort(line);
            StringBuilder builder = new StringBuilder();
            for (Point point : line) {
                builder.append(point);
                builder.append(POINT_SEPARATOR);
            }
            builder.setLength(builder.length() - POINT_SEPARATOR.length());
            StdOut.println(builder.toString());
            Collections.min(line).drawTo(Collections.max(line));
    }
}
