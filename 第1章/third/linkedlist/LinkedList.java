public class LinkedList<Item> {

    private Node<Item> first;

    public LinkedList() {
    }

    public LinkedList(Node<Item> first) {
        this.first = first;
    }

    public void add(Node<Item> node) {
        if (first == null) {
            first = node;
        } else {
            Node<Item> tmp = first;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }

    /**
     * print the linkedList
     */
    public void printLinkedList() {
        this.printLinkedList(first);
    }
    public void printLinkedList(Node<Item> node) {
        while (node != null) {
            System.out.print(node.item);
            if (node.next != null) {
                System.out.print(" --> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 1.3.19
     */
    public void removeLast() {
        if (first == null) {
            return;
        }
        if (first.next == null) {
            first = null;
        }
        Node<Item> node = first;
        while (node.next.next != null) {
            node = node.next;
        }
        node.next = null;
    }

    /**
     * 1.3.20
     */
    public void delete(int k) {
        assert k > 0 : "k must be > 0";
        Node<Item> dummyNode = new Node<>();
        dummyNode.next = first;
        Node<Item> node = dummyNode;
        while (k > 1 && node.next != null) {
            node = node.next;
            k--;
        }
        if (k == 1 && node.next != null) {
            node.next = node.next.next;
        }
        first = dummyNode.next;
    }

    /**
     * 1.3.21
     */
    public boolean find(Item key) {
        Node<Item> x = first;
        while (x != null) {
            if (x.item.equals(key)) {
                return true;
            }
            x = x.next;
        }
        return false;
    }

    /**
     * 1.3.24
     */
    public void removeAfter(Node<Item> node) {
        if (node != null && node.next != null) {
            node.next = node.next.next;
        }
    }

    /**
     * 1.3.25
     */
    public void insertAfter(Node<Item> x, Node<Item> y) {
        if (x != null && y != null) {
            y.next = x.next;
            x.next = y;
        }
    }

    /**
     * 1.3.26
     */
    public Node<Item> remove(Node<Item> first, Item key) {
        Node<Item> dummyNode = new Node<>();
        dummyNode.next = first;
        Node<Item> tmp = dummyNode;
        while (tmp.next != null) {
            if (tmp.next.item.equals(key)) {
                Node<Item> nxt = tmp.next;
                tmp.next = nxt.next;
                nxt.next = null;
            } else {
                tmp = tmp.next;
            }
        }
        return dummyNode.next;
    }

    /**
     * 1.3.27
     */
//    public static <Item extends Comparable<Item>> Item max(Node<Item> head) {
//        if (head == null) {
//            return null; // 链表为空，返回null
//        }
//        Item max = head.item; // 初始化max为链表的第一个节点的值
//        Node<Item> curr = head.next; // 从链表的第二个节点开始遍历
//        while (curr != null) {
//            if (curr.item.compareTo(max) > 0) { // 如果当前节点的值大于max，则更新max
//                max = curr.item;
//            }
//            curr = curr.next; // 遍历下一个节点
//        }
//        return max; // 返回最大值
//    }

    /**
     * 1.3.28
     */
    public static <Item extends Comparable<Item>> Item max(Node<Item> head) {
        if (head == null) {
            return null;
        } else {
            Item max = max(head.next);
            if (max == null) {
                return head.item;
            } else {
                return head.item.compareTo(max) > 0 ? head.item : max;
            }
        }
    }
}
