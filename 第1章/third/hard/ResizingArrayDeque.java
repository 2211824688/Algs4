import java.util.NoSuchElementException;

/**
 * 1.3.33
 */
public class ResizingArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int first; // 指向队头元素
    private int last; // 指向队尾元素

    public ResizingArrayDeque() {
        items = (Item[]) new Object[100];
        size = 0;
        first = 0;
        last = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = items[(first + i) % items.length];
        }
        items = copy;
        first = 0;
        last = size;
    }

    public void pushLeft(Item item) {
        if (size == items.length) {
            resize(2 * items.length);
        }
        first = (first - 1 + items.length) % items.length;
        items[first] = item;
        size++;
    }

    public void pushRight(Item item) {
        if (size == items.length) {
            resize(2 * items.length);
        }
        items[last] = item;
        last = (last + 1) % items.length;
        size++;
    }

    public Item popLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = items[first];
        items[first] = null;
        first = (first + 1) % items.length;
        size--;
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    public Item popRight() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        last = (last - 1 + items.length) % items.length;
        Item item = items[last];
        items[last] = null;
        size--;
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    public static void main(String[] args) {
        ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();
        deque.pushLeft(1);
        deque.pushRight(2);
        deque.pushLeft(3);
        deque.pushRight(4);
        // 3 1 2 4
        while (!deque.isEmpty()) {
            System.out.print(deque.popLeft() + " ");
        }
    }
}
