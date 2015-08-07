import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: SBT-Levochkin-AN
 * Date: 16.03.14
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
public class PercolationTest {
    @Test
    public void input6() {

    }


    @Test
    public void input1() {
        Percolation percolation = new Percolation(1);
        assertFalse(percolation.percolates());
        percolation.open(1, 1);
        assertTrue(percolation.percolates());
        assertTrue(percolation.isOpen(1, 1));
        assertTrue(percolation.isFull(1, 1));
    }

    @Test
    public void input1No() {
        Percolation percolation = new Percolation(1);
        assertFalse(percolation.percolates());
        assertFalse(percolation.isOpen(1, 1));
        assertFalse(percolation.isFull(1, 1));
    }

    @Test
    public void input2() {
        Percolation percolation = new Percolation(2);
        assertFalse(percolation.percolates());
        assertFalse(percolation.isOpen(1, 1));
        assertFalse(percolation.isOpen(1, 2));
        assertFalse(percolation.isOpen(2, 1));
        assertFalse(percolation.isOpen(2, 2));
        assertFalse(percolation.isFull(1, 1));
        assertFalse(percolation.isFull(1, 2));
        assertFalse(percolation.isFull(2, 1));
        assertFalse(percolation.isFull(2, 2));
        percolation.open(1, 1);
        assertFalse(percolation.percolates());
        assertTrue(percolation.isOpen(1, 1));
        assertFalse(percolation.isOpen(1, 2));
        assertFalse(percolation.isOpen(2, 1));
        assertFalse(percolation.isOpen(2, 2));
        assertTrue(percolation.isFull(1, 1));
        assertFalse(percolation.isFull(1, 2));
        assertFalse(percolation.isFull(2, 1));
        assertFalse(percolation.isFull(2, 2));
        percolation.open(2, 2);
        assertFalse(percolation.percolates());
        assertTrue(percolation.isOpen(1, 1));
        assertFalse(percolation.isOpen(1, 2));
        assertFalse(percolation.isOpen(2, 1));
        assertTrue(percolation.isOpen(2, 2));
        assertTrue(percolation.isFull(1, 1));
        assertFalse(percolation.isFull(1, 2));
        assertFalse(percolation.isFull(2, 1));
        assertFalse(percolation.isFull(2, 2));
        percolation.open(1, 2);
        assertTrue(percolation.percolates());
        assertTrue(percolation.isOpen(1, 1));
        assertTrue(percolation.isOpen(1, 2));
        assertFalse(percolation.isOpen(2, 1));
        assertTrue(percolation.isOpen(2, 2));

        assertTrue(percolation.isFull(1, 1));
        assertTrue(percolation.isFull(1, 2));
        assertFalse(percolation.isFull(2, 1));
        assertTrue(percolation.isFull(2, 2));
    }


    @Test
    public void test() {
        Percolation percolation = new Percolation(10);
        assertFalse(percolation.percolates());
        assertFalse(percolation.isFull(1, 1));
        assertFalse(percolation.isOpen(1, 1));
        assertFalse(percolation.isOpen(2, 1));
        percolation.open(1, 1);
        assertTrue(percolation.isFull(1, 1));
        assertTrue(percolation.isOpen(1, 1));

        assertFalse(percolation.isOpen(2, 1));
        percolation.open(2, 1);
        assertTrue(percolation.isOpen(2, 1));
    }

    @Test
    public void test1() {
        Percolation percolation = new Percolation(6);
        assertFalse(percolation.isFull(1, 6));
        percolation.open(1, 6);
        assertTrue(percolation.isFull(1, 6));
        percolation.open(2, 6);
        assertTrue(percolation.isFull(2, 6));
        percolation.open(3, 6);
        assertTrue(percolation.isFull(3, 6));
        percolation.open(4, 6);
        assertTrue(percolation.isFull(4, 6));
        percolation.open(5, 6);
        assertTrue(percolation.isFull(5, 6));
        percolation.open(5, 5);
        assertTrue(percolation.isFull(5, 5));

        percolation.open(2, 6);
        percolation.open(3, 6);
        percolation.open(4, 6);
        percolation.open(5, 6);
        percolation.open(6, 6);
        assertTrue(percolation.percolates());
    }

    @Test
    public void test2() {
        Percolation percolation = new Percolation(1);
        assertFalse(percolation.percolates());
        percolation.open(1, 1);
        assertTrue(percolation.percolates());
    }

    @Test
    public void test3() {
        Percolation percolation = new Percolation(4);
        percolation.open(4, 1);
        percolation.open(3, 1);
        percolation.open(2, 1);
        percolation.open(1, 1);
        percolation.open(1, 4);
        percolation.open(2, 4);
        percolation.open(4, 4);
        assertFalse(percolation.isFull(4, 4));
        percolation.open(3, 4);

    }

}
