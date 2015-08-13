import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * @author alevochkin.
 */
public class PointTest {
    @Test
    public void testSlope() {
        Point p = new Point(1, 1);
        Point q = new Point(1, 9);
        System.out.println("DEBUG:" + p.slopeTo(q));
        p = new Point(8086, 12442);
        q = new Point(8086, 22733);
        System.out.println("DEBUG:" + p.slopeTo(q));
        p = new Point(0, 3);
        q = new Point(0, 3);
        System.out.println("DEBUG:" + p.slopeTo(q));
        p = new Point(19602, 22678);
        q = new Point(29794, 22678);
        System.out.println("DEBUG:" + p.slopeTo(q));
    }

    @Test
    public void testSlopOrder() {
        Point p = new Point(184, 189);
        Point q = new Point(227, 208);
        Point r = new Point(438, 121);
        Point s = new Point(332, 82);
        Assert.assertThat( p.SLOPE_ORDER.compare(q, r), is(1));
        Assert.assertThat( p.SLOPE_ORDER.compare(r, s), is(1));
        Assert.assertThat( p.SLOPE_ORDER.compare(q, s), is(1));
    }
}
