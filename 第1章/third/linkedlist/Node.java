public class Node<Item> {
    Item item;
    Node<Item> next;

    public Node() {
    }

    public Node(Item val) {
        this.item = val;
    }

    public Node(Item item, Node<Item> next) {
        this.item = item;
        this.next = next;
    }

}
