import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    //private long salt = 0;
    private Item[] queue;
    private int size = 0;

    /**
     * construct an empty randomized queue
     */
    public RandomizedQueue() {
        queue = (Item[]) new Object[2];
    }

    /**
     * Return true if the queue is empty else return false
     *
     * @return is queue empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * return the number of items on the queue
     *
     * @return size of queue
     */
    public int size() {
        return size;
    }

    /**
     * add the item
     *
     * @param item the item
     */
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException("Item cannot be null.");
        }
        if (size == queue.length) {
            resize(2 * size);
        }
        queue[size++] = item;
    }

    /**
     * remove and return a random item
     *
     * @return a random item
     */
    public Item dequeue() {
        if (size() == 0) {
            throw new NoSuchElementException("Dequeue item from empty queue.");
        }
        int randomIndex = getRandomIndex();
        Item result = queue[randomIndex];
        queue[randomIndex] = queue[size - 1];
        queue[size - 1] = null;
        size--;
        if (size > 0 && size == queue.length / 4) {
            resize(queue.length / 2);
        }
        return result;
    }

    /**
     * return (but do not remove) a random item
     *
     * @return a random item
     */
    public Item sample() {
        if (size() == 0) {
            throw new NoSuchElementException("Sample item from empty queue.");
        }
        int randomIndex = getRandomIndex();
        return queue[randomIndex];
    }

    private int getRandomIndex() {
        return StdRandom.uniform(size);
    }

    /**
     * return an independent iterator over items in random order
     *
     * @return iterator
     */
    public Iterator<Item> iterator() {
        //return new ArrayIterator(StdRandom.uniform(100000));
        return new RandomizedIterator();
    }

    // resize the underlying array
    private void resize(int max) {
        assert max >= size;
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[i];
        }
        queue = temp;
    }

    private class RandomizedIterator implements Iterator<Item> {
        private int current = 0;
        private int[] shuffledIndexes = new int[size];

        public boolean hasNext() {
            if (current == 0) {
                for (int i = 0; i < size; i++)
                    shuffledIndexes[i] = i;
                StdRandom.shuffle(shuffledIndexes);
            }
            return current < size;
        }
        public Item next() {
            if (current == 0) {
                for (int i = 0; i < size; i++)
                    shuffledIndexes[i] = i;
                StdRandom.shuffle(shuffledIndexes);
            }
            if (current >= size || size() == 0) throw new java.util.NoSuchElementException();
            return queue[shuffledIndexes[current++]];
        }
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;

        public ArrayIterator(long salt) {
            StdRandom.setSeed(salt);
        }

        public boolean hasNext() {
            return i < size;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            int index = StdRandom.uniform(i, size);
            Item item = queue[index];
            queue[index] = queue[i];
            //Item item = queue[i];
            i++;
            return item;
        }
    }


    /**
     * unit testing
     */
    public static void main(String[] args) {

    }
}