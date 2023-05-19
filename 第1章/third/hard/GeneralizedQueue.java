import java.util.NoSuchElementException;

/**
 * 1.3.38
 * @param <Item>
 */
public class GeneralizedQueue<Item> {
    private Item[] items;
    private int size;

    public GeneralizedQueue() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    private void resize() {
        Item[] newItems = (Item[]) new Object[2*items.length + 1];
        System.arraycopy(items, 0, newItems, 0, items.length);
        items = newItems;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(Item x) {
        if (size >= items.length) {
            resize();
        }
        items[size++] = x;
    }

    public Item delete(int k) {
        if (k > size) {
            throw new NoSuchElementException("k must be <= the size of queue");
        }
        Item item = items[k-1];
        for (int i = k-1; i < size-1; i++) {
            items[i] = items[i+1];
        }
        size--;
        return item;
    }

    public static void main(String[] args) {
        GeneralizedQueue<Integer> generalizedQueue = new GeneralizedQueue<>();
        for (int i = 0; i < 200; i++) {
            generalizedQueue.insert(i);
        }
        while (!generalizedQueue.isEmpty()) {
            System.out.println(generalizedQueue.delete(1));
        }
    }
}
