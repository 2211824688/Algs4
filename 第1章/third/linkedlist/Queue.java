import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.3.29
 * 环形链表实现队列
 */
public class Queue<Item> implements Iterable<Item> {
    private Node<Item> last;
    private int n;

    public Queue() {
        last = null;
        n = 0;
    }

    /**
     * 1.3.41
     */
    public Queue(Queue<Item> queue) {
        for (Item item : queue) {
            this.enqueue(item);
        }
        n = queue.size();
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

    public Iterator<Item> iterator()  {
        return new LinkedIterator(last);
    }

    // a linked-list iterator
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;
        private int cnt;

        public LinkedIterator(Node<Item> last) {
            if (last == null) {
                current = null;
            } else {
                current = last.next;
            }
            cnt = 0;
        }

        public boolean hasNext() {
            return cnt < size();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            cnt++;
            return item;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        Queue<Integer> r = new Queue<>(queue);
        while (!r.isEmpty()) {
            System.out.println(r.dequeue());
        }
        System.out.println("queue size : " + queue.size() + "  r size : " + r.size());
    }
}
