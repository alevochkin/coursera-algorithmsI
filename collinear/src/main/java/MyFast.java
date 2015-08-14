import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author alevochkin.
 */
public class MyFast {
    private static final String POINT_SEPARATOR = "->";

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new RuntimeException("Please enter input file");
        }
        In in = new In(args[0]);
        Point[] points = new Point[in.readInt()];

        //StdDraw.setXscale(0, 32768);
        //StdDraw.setYscale(0, 32768);

        for (int i = 0; i < points.length; i++) {
            Point point = new Point(in.readInt(), in.readInt());
            points[i] = point;
            //point.draw();
        }

        //Arrays.sort(points);
        List<List<Point>> lines = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            Point origin = points[i];
            int newLength = points.length - (i + 1);
            Point[] aux = new Point[newLength];
            System.arraycopy(points, i + 1, aux, 0, newLength);
            MergeX.sort(aux, origin.SLOPE_ORDER);

            List<Point> line = new ArrayList<>();
            //the first one is origin
            //for (int j = 0; j < points.length; j++) {
            for (int j = 0; j < aux.length; j++) {
                //double slope = origin.slopeTo(points[j]);
                if (line.isEmpty()) {
                    line.add(origin);
                } else if (j == 0 && origin.slopeTo(aux[0]) == origin.slopeTo(aux[1])) {
                    line.add(aux[0]);
                } else if (origin.slopeTo(aux[j - 1]) == origin.slopeTo(aux[j])) {
                    line.add(aux[j - 1]);
                } else {
                    line.add(aux[j - 1]);
                    Collections.sort(line);
                    if (line.size() >= 4 && !contains(lines, line)) {
                        printLine(line);
                        lines.add(line);
                    } else {
                        line.clear();
                    }
                }
                /*for (Point point : aux) {
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
                }*/
            }

        }
    }

    private static boolean contains(List<List<Point>> lines, List<Point> points) {
        for(List<Point> line : lines) {
            if(line.get(0).compareTo(points.get(0)) == 0) {
                return true;
            }
        }
        return false;
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
        //Collections.min(line).drawTo(Collections.max(line));
    }
}
