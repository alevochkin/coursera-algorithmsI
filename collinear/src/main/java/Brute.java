import java.util.Arrays;

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

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        for (int i = 0; i < number; i++) {
            Point point = new Point(in.readInt(), in.readInt());
            points[i] = point;
            point.draw();
        }

        for (int p = 0; p < number; p++) {
            for (int q = p + 1; q < number; q++) {
                double slopeToQ = points[p].slopeTo(points[q]);
                for (int r = q + 1; r < number; r++) {
                    double slopeToR = points[p].slopeTo(points[r]);
                    if (slopeToQ == slopeToR) {
                        for (int s = r + 1; s < number; s++) {
                            double slopToS = points[p].slopeTo(points[s]);
                            if (slopeToQ == slopToS) {
                                Point[] line = new Point[4];
                                line[0] = points[p];
                                line[1] = points[q];
                                line[2] = points[r];
                                line[3] = points[s];
                                printLine(line);
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
            builder.append("->");
        }
        builder.setLength(builder.length() - 2);
        StdOut.println(builder.toString());
        line[0].drawTo(line[3]);
        //Arrays.min(line).drawTo(Arrays.max(line));
    }
}
