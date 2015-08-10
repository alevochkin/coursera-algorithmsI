/**
 * @author alevochkin.
 */
public class PointTest {
    @org.junit.Test
    public void testSlope() {
        Point p = new Point(3, 8);
        Point q = new Point(3, 5);
        System.out.println("DEBUG:" + p.slopeTo(q));
    }
}
