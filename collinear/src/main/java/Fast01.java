import java.util.Arrays;

/**
 * @author alevochkin
 */
public class Fast01 {
    public static void main(String[] args) {

        int n = 0;

        In inputFile;
        Point[] points;
        Point lastPoint = null;

        inputFile = new In(args[0]);

        // How many points do we have in the input file?
        n = inputFile.readInt();

        // Allocate enough space for them
        points = new Point[n];

        // Rescale coordinate system for proper visualization.
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        for (int i = 0; !inputFile.isEmpty(); i++) {
            int x = inputFile.readInt();
            int y = inputFile.readInt();

            Point point = new Point(x, y);
            points[i] = point;
            point.draw();
        }

        Arrays.sort(points);

        Point[] sortedPoints = new Point[n];

        for (int i = 0; i < n; i++) {
            // Pick the origin
            Point origin = points[i];
            // Copy points
            System.arraycopy(points, 0, sortedPoints, 0, sortedPoints.length);
            // Sort all points according slope origin
            Arrays.sort(sortedPoints, i, n, origin.SLOPE_ORDER);

            int low = 0;
            int high = 0;

            double lastSlope = origin.slopeTo(sortedPoints[i]);

            for (int k = i + 1; k < n; k++) {

                double currentSlope = origin.slopeTo(sortedPoints[k]);

                if (currentSlope == lastSlope) {
                    high++;
                } else {
                    if (high - low >= 2 && sortedPoints[high] != lastPoint) {
                        lastPoint = sortedPoints[high];

                        StdOut.print(origin);

                        for (int j = low; j <= high; j++)
                            StdOut.print(" -> " + sortedPoints[j]);

                        StdOut.println();

                        origin.drawTo(sortedPoints[high]);
                    }

                    low = k;
                    high = k;
                    lastSlope = currentSlope;
                }
            }

            if (high - low >= 2 && sortedPoints[high] != lastPoint) {
                lastPoint = sortedPoints[high];

                StdOut.print(origin);

                for (int j = low; j <= high; j++)
                    StdOut.print(" -> " + sortedPoints[j]);

                StdOut.println();

                origin.drawTo(sortedPoints[high]);
            }
        }
    }
}
