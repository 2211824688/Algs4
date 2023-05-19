/**
 * 1.3.33
 */
public class Deque<Item> {
    DoubledList<Item> doubledList;
    int n;

    public Deque() {
        doubledList = new DoubledList<>();
    }

    public boolean isEmpty() {
        return doubledList.isEmpty();
    }

    public int size() {
        return doubledList.size();
    }

    public void pushLeft(Item item) {
        doubledList.insertFirst(item);
    }

    public void pushRight(Item item) {
        doubledList.insertLast(item);
    }

    public Item popLeft() {
        return doubledList.removeFirst();
    }

    public Item popRight() {
        return doubledList.removeLast();
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i < 10; i++) {
            deque.pushLeft(i);
            deque.pushRight(i);
        }
        while (deque.size() > 0) {
            System.out.print(deque.popRight() + " ");
        }
    }
}
