/**
 * 1.3.31
 */
public class DoubledList<Item> {

    private DoubleNode<Item> first;
    private DoubleNode<Item> last;
    private int n;

    private static class DoubleNode<Item> {
        Item item;
        DoubleNode<Item> prev;
        DoubleNode<Item> next;
    }

    public DoubledList() {
        first = null;
        last = null;
        n = 0;
    }

    public void insertFirst(Item item) {
        DoubleNode<Item> newFirst = new DoubleNode<>();
        newFirst.item = item;
        if (first == null) {
            first = newFirst;
            last = newFirst;
        } else {
            newFirst.next = first;
            first.prev = newFirst;
            first = newFirst;
        }
        n++;
    }

    public void insertLast(Item item) {
        DoubleNode<Item> newLast = new DoubleNode<>();
        newLast.item = item;
        if (last == null) {
            last = newLast;
            first = newLast;
        } else {
            newLast.prev = last;
            last.next = newLast;
            last = newLast;
        }
        n++;
    }

    public Item removeFirst() {
        if (first == null) {
            return null;
        } else {
            DoubleNode<Item> newFirst = first.next;
            Item item = first.item;
            first.next = null;
            if (newFirst != null) {
                newFirst.prev = null;
            } else {
                last = null;
            }
            first = newFirst;
            n--;
            return item;
        }
    }

    public Item removeLast() {
        if (last == null) {
            return null;
        } else {
            DoubleNode<Item> newLast = last.prev;
            Item item = last.item;
            last.prev = null;
            if (newLast != null) {
                newLast.next = null;
            } else {
                first = null;
            }
            last = newLast;
            n--;
            return item;
        }
    }

    /**
     *
     * @param item  被插入的节点
     * @param val   插入的值
     */

    public void insertBefore(Item item, Item val) {
        DoubleNode<Item> x = first;
        while (x != null && !x.item.equals(item)) {
            x = x.next;
        }
        if (x != null) {
            DoubleNode<Item> node = new DoubleNode<>();
            node.item = val;
            DoubleNode<Item> prev = x.prev;
            x.prev = node;
            node.next = x;
            node.prev = prev;
            if (prev != null) {
                prev.next = node;
            }
            n++;
        }
    }

    /**
     *
     * @param item  被插入的节点
     * @param val   插入的值
     */

    public void insertAfter(Item item, Item val) {
        DoubleNode<Item> x = first;
        while (x != null && !x.item.equals(item)) {
            x = x.next;
        }
        if (x != null) {
            DoubleNode<Item> node = new DoubleNode<>();
            node.item = val;
            DoubleNode<Item> nxt = x.next;
            x.next = node;
            node.prev = x;
            node.next = nxt;
            if (nxt != null) {
                nxt.prev = node;
            }
            n++;
        }
    }

    public void delete(Item item) {
        if (item.equals(first.item)) {
            removeFirst();
        } else if (item.equals(last.item)) {
            removeLast();
        } else {
            DoubleNode<Item> x = first;
            while (x != null && !x.item.equals(item)) {
                x = x.next;
            }
            if (x != null) {
                DoubleNode<Item> prev = x.prev;
                DoubleNode<Item> next = x.next;
                prev.next = next;
                next.prev = prev;
                x.prev = null;
                x.next = null;
                n--;
            }
        }
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }

    public int size() {
        return n;
    }

    public void print() {
        DoubleNode<Item> x = first;
        while (x != null) {
            System.out.print(x.item);
            if (x.next != null) {
                System.out.print(" <---> ");
            }
            x = x.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubledList<Integer> doubledList = new DoubledList<>();
        for (int i = 0; i < 10; i++) {
            doubledList.insertLast(i);
        }
        doubledList.print();
        doubledList.insertBefore(1, 20);
        doubledList.insertAfter(20, 80);
        doubledList.print();
        System.out.println(doubledList.size());
        doubledList.delete(20);
        doubledList.print();
        System.out.println(doubledList.size());
    }
}
