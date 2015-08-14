import java.util.Arrays;

public class Fast {
    /**
     * Collinear will take an array of points and determine all of the other
     * points that are collinear each point.
     *
     * @param points
     * @return List<HashSet<Point>> List of results. Each HashSet in the list
     *         represents a set of points that comprise a single line for hte
     *         given input.
     */
    private static void collinear(Point[] points) {
        // iterate over all of the points
        Arrays.sort(points);
        int N = points.length;
        for (int i = 0; i < N - 4; i++) {
            // sort based upon current items point
            Point origin = points[i];
            int j = i + 1;
            Arrays.sort(points, j, N, points[i].SLOPE_ORDER);
            double slope = origin.slopeTo(points[j]);
            int count = 1;
            for (;;) {
                for (; ++j < N && origin.slopeTo(points[j]) == slope;) {
                    count++;
                }

                if (count >= 3) {
                    Point[] segment = new Point[count + 1];
                    segment[0] = origin;
                    System.arraycopy(points, j - count, segment, j - count - (j - count)
                            + 1, j - (j - count));
                    Arrays.sort(segment);

                    segment[0].drawTo(segment[segment.length - 1]);
                    for (int k = 0; k < segment.length; k++) {
                        if (k == 0) {
                            StdOut.print(segment[k]);
                        } else {
                            StdOut.print(" -> " + segment[k]);
                        }
                    }
                    StdOut.println();

                }
                if (j + 1 < N) {
                    slope = origin.slopeTo(points[j]);
                    count = 1;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);

        String filename = args[0];

        In in = new In(filename);
        int N = in.readInt();
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            points[i] = p;
            p.draw();
        }
        Fast.collinear(points);
        StdDraw.show(0);
    }
}