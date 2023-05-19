import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.3.34
 *
 */
public class RandomBag<Item> implements Iterable<Item> {

    private Item[] items;
    private int size;
    private static final int defaultSize = 50;

    public RandomBag() {
        items = (Item[]) new Object[defaultSize];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Item item) {
        if (size == items.length) {
            resize();
        }
        items[size] = item;
        size++;
    }

    private void resize() {
        Item[] newItems = (Item[]) new Object[2*items.length + 1];
        System.arraycopy(items, 0, newItems, 0, items.length);
        items = newItems;
    }

    public Iterator<Item> iterator()  {
        return new ArrayIterator(items, size);
    }

    private class ArrayIterator implements Iterator<Item> {
        private final Item[] items;
        private int cur;

        public ArrayIterator(Item[] items, int size) {
            this.items = items;
            cur = size - 1;
            StdRandom.shuffle(items, 0, size);
        }

        public boolean hasNext()  {
            return cur >= 0;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = items[cur];
            cur--;
            return item;
        }
    }

    public static void main(String[] args) {
        RandomBag<Integer> bag = new RandomBag<>();
        for (int i = 0; i < 10; i++) {
            bag.add(i);
        }
        Iterator<Integer> iterator = bag.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
