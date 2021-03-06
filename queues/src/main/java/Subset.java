public class Subset {
    public static void main(String[] args) {
        /*int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        String input = StdIn.readString();
        String[] split = input.split(" ");
        for (String str : split) {
            queue.enqueue(str);
        }
        assert 0 <= k;
        assert k <= split.length;

        for (String str : queue) {
            if (k == 0) {
                break;
            }
            StdOut.println(str);
            k--;
        }*/
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        // read strings from std input:
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            rq.enqueue(s);
        }

        int k = Integer.parseInt(args[0]);
        for (int i = 0; i < k; i++) {
            StdOut.println(rq.dequeue());
        }
    }
}