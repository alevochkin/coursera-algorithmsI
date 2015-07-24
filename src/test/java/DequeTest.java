import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author alevochkin
 */
public class DequeTest {
    @org.junit.Test
    public void test1() {
        Deque<Double> queue = new Deque<>();
        queue.addFirst(0.8);
        queue.addFirst(0.0);
        assertFalse(queue.isEmpty());
        queue.removeFirst();
        queue.removeFirst();
        assertTrue(queue.isEmpty());
        queue.addFirst(0.8);
        queue.addFirst(0.0);
        assertFalse(queue.isEmpty());
        queue.addFirst(0.1);
        queue.addFirst(0.0);
        queue.removeFirst();
        assertFalse(queue.isEmpty());
        queue.removeFirst();
        queue.removeFirst();
        assertFalse(queue.isEmpty());
        queue.addFirst(0.0);
        queue.addFirst(0.0);
        queue.addFirst(0.1);
        queue.addFirst(0.1);
        queue.addFirst(0.8);
        queue.removeFirst();
        assertFalse(queue.isEmpty());
        queue.removeFirst();
        queue.removeFirst();
    }

    @org.junit.Test
    public void test2() {
        Deque<Double> queue = new Deque<>();
        queue.addFirst(0.8);
        queue.addFirst(0.0);
        assertFalse(queue.isEmpty());
        queue.removeLast();
        queue.removeLast();
        assertTrue(queue.isEmpty());
        queue.addFirst(0.8);
        queue.addFirst(0.0);
        assertFalse(queue.isEmpty());
        queue.addFirst(0.1);
        queue.addFirst(0.0);
        queue.removeLast();
        assertFalse(queue.isEmpty());
        queue.removeLast();
        queue.removeLast();
        assertFalse(queue.isEmpty());
        queue.addFirst(0.0);
        queue.addFirst(0.0);
        queue.addFirst(0.1);
        queue.addFirst(0.1);
        queue.addFirst(0.8);
        queue.removeLast();
        assertFalse(queue.isEmpty());
        queue.removeLast();
        queue.removeLast();
    }
    @org.junit.Test
    public void test3() {
        Deque<Double> queue = new Deque<>();
        queue.addLast(0.8);
        queue.addFirst(0.0);
        queue.addLast(0.8);
        queue.addLast(0.0);
        assertFalse(queue.isEmpty());
        queue.addLast(0.8);
        assertEquals(5, queue.size());
        queue.addFirst(0.0);
        queue.addFirst(0.8);
        queue.addLast(0.0);
        assertEquals(8, queue.size());
        queue.addFirst(0.8);
        queue.addLast(0.0);
        queue.addLast(0.8);
        queue.addFirst(0.0);
        assertEquals(12, queue.size());
    }

}
