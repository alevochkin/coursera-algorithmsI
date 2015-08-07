/**
 * @author alevochkin.
 */
public class Brute {
    public static void main(String[] args) {
        if(args.length < 1) {
            throw new RuntimeException("Please enter inout file");
        }
        In in = new In(args[0]);
        int number = in.readInt();
        Point[] points = new Point[number];
        for(int i = 0; i < number; i++) {
            points[i] = new Point(in.readInt(), in.readInt());
        }
    }
}
