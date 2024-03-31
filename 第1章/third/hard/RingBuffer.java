/**
 * 1.3.39
 */
public class RingBuffer<Item> {
    private Item[] buffer;
    private int size;
    private int head;
    private int tail;

    public RingBuffer(int capacity) {
        buffer = (Item[]) new Object[capacity];
        size = 0;
        head = 0;
        tail = 0;
    }

    public synchronized int size() {
        return size;
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }

    public synchronized boolean isFull() {
        return size == buffer.length;
    }

    public synchronized void enqueue(Item item) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        buffer[tail] = item;
        tail = (tail + 1) % buffer.length;
        size++;
        notifyAll();
    }

    public synchronized Item dequeue() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        Item item = buffer[head];
        buffer[head] = null;
        head = (head + 1) % buffer.length;
        size--;
        notifyAll();
        return item;
    }

}
