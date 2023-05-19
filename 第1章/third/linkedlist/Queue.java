import java.util.NoSuchElementException;

/**
 * 1.3.29
 */
public class Queue<Item> {
    private Node<Item> last;
    private int n;

    public Queue() {
        last = null;
        n = 0;
    }

    public void enqueue(Item item) {
        Node<Item> node = new Node<>();
        node.item = item;
        if (n == 0) {
            node.next = node;
        } else {
            Node<Item> first = last.next;
            last.next = node;
            node.next = first;
        }
        last = node;
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        } else if (n == 1) {
            Item first = last.item;
            last = null;
            n = 0;
            return first;
        } else {
            Item first = last.next.item;
            last.next = last.next.next;
            n--;
            return first;
        }
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public void printQueue() {
        if (last == null) {
            return;
        }
        Node<Item> tmp = last.next;
        while (!tmp.equals(last)) {
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
        }
        System.out.println(tmp.item);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        queue.printQueue();
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.dequeue());
        }
        queue.printQueue();
    }
}
