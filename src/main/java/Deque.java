import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int size;
    private Node<Item> first;
    private Node<Item> last;

    /**
     * construct an empty deque
     */
    public Deque() {
    }

    /**
     * Return true if deque is empty else return false.
     *
     * @return is the deque empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * return the number of items on the deque
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * add the item to the front
     *
     * @param item the item
     */
    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException("Item cannot be null.");
        }
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.previously = null;
        first.next = oldFirst;
        if (oldFirst != null) {
            oldFirst.previously = first;
        }
        if (last == null) {
            last = first;
        }
        size++;
    }

    /**
     * add the item to the end
     *
     * @param item the item
     */
    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException("Item cannot be null.");
        }
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        if (oldLast != null) {
            last.previously = oldLast;
            oldLast.next = last;
        }
        if (first == null) {
            first = last;
        }
        size++;
    }

    /**
     * remove and return the item from the front
     *
     * @return the item
     */
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Remove item from empty deqeu.");
        }
        Item result = first.item;
        if (first.next != null) {
            first = first.next;
            first.previously = null;
        } else {
            first = null;
        }
        size--;
        if (isEmpty()) {
            last = null;
        }
        return result;
    }

    /**
     * remove and return the item from the end
     *
     * @return the item
     */
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Remove item from empty deqeu.");
        }
        Item result = last.item;
        if (last.previously != null) {
            last = last.previously;
            last.next = null;
        } else {
            last = null;
            first = null;
        }
        size--;
        return result;
    }

    /**
     * return an iterator over items in order from front to end
     *
     * @return the item
     */
    public Iterator<Item> iterator() {
        return new ListIterator<>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> previously;
    }

    /**
     * unit testing
     */
    public static void main(String[] args) {

    }
}