import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.3.35   1.3.36
 * @param <Item>
 */
public class RandomQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int size;

    public RandomQueue() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Item item) {
        if (size == items.length) {
            resize();
        }
        items[size++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Queue!");
        }
        int randomIndex = StdRandom.uniformInt(0, size);
        Item tmp = items[randomIndex];
        items[randomIndex] = items[size-1];
        items[size-1] = tmp;
        size--;
        return tmp;
    }

    public Item sample() {
        int randIndex = StdRandom.uniformInt(0, size);
        return items[randIndex];
    }

    private void resize() {
        Item[] newItems = (Item[]) new Object[items.length*2 + 1];
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
            StdRandom.shuffle(this.items, 0, size);
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
        RandomQueue<String> randomQueue = new RandomQueue<>();
        randomQueue.enqueue("f");
        randomQueue.enqueue("u");
        randomQueue.enqueue("c");
        randomQueue.enqueue("k");
        Iterator<String> iterator = randomQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
