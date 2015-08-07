import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class RandomizedQueueTest {
    @Test
    public void test5() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        assertThat(queue.isEmpty(), is(true));
        assertThat(queue.size(), is(0));
        queue.enqueue(138);
        queue.dequeue();
        assertThat(queue.isEmpty(), is(true));
        assertThat(queue.size(), is(0));
        queue.enqueue(65);
        queue.dequeue();
        assertThat(queue.size(), is(0));
        queue.enqueue(151);
        Integer item = queue.dequeue();
        assertNotNull(item);
    }

    @org.junit.Test
    public void test1() {
        StdOut.println("=======================================================");
        String input = "AA BB CC DD EE FF GG HH";
        StdOut.println(input);
        RandomizedQueue<String> queue = getQueue(input);
        print(queue, 8, 8);
    }

    @org.junit.Test
    public void test2() {
        StdOut.println("=======================================================");
        String input = "A B C D E F G H I";
        StdOut.println(input);
        RandomizedQueue<String> queue = getQueue(input);
        print(queue, 3, 9);
    }

    @org.junit.Test
    public void test3() {
        StdOut.println("=======================================================");
        String input = "A B C D E F G H I";
        StdOut.println(input);
        RandomizedQueue<String> queue = getQueue(input);
        print(queue, 3, 9);
    }

    @org.junit.Test
    public void test4() {
        StdOut.println("=======================================================");
        String input = "AA BB BB BB BB BB CC CC";
        StdOut.println(input);
        RandomizedQueue<String> queue = getQueue(input);
        print(queue, 7, 8);
    }

    @org.junit.Test
    public void test6() {
        StdOut.println("=======================================================");
        String input = "AA BB BB BB BB BB CC CC ";
        StdOut.println(input);
        RandomizedQueue<String> queue = getQueue(input);
        print(queue, 8, 8);
    }

    private void print(RandomizedQueue<String> queue, int k, int N) {
        if (k < 0 || k > N) {
            throw new IllegalArgumentException("Wrong k and N. Must be 0 ≤ k ≤ N");
        }
        for(String str : queue) {
            if(k == 0) {
                break;
            }
            StdOut.println(str);
            k--;
        }
    }

    private RandomizedQueue<String> getQueue(String input) {
        String[] split = input.split(" ");
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        for(String str : split) {
            queue.enqueue(str);
        }
        return queue;
    }
}
