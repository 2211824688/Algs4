import org.junit.Test;

public class LinkedListTest {
    @Test
    public void testLinkedList() {
        Node<String> first = new Node<>("1");
        LinkedList<String> linkedList = new LinkedList<>(first);
        linkedList.add(new Node<>("2"));
        linkedList.add(new Node<>("3"));
        linkedList.add(new Node<>("4"));
        // 1 --> 2 --> 3 --> 4

//        // test removeLast()
//        linkedList.printLinkedList();
//        linkedList.removeLast();
//        System.out.println();
//        linkedList.printLinkedList();

//        //test delete(int k)
//        linkedList.delete(3);
//        linkedList.printLinkedList();

//        linkedList.printLinkedList();
//        linkedList.insertAfter(first, new Node<>("123"));
//        linkedList.printLinkedList();
//        linkedList.removeAfter(first);
//        linkedList.printLinkedList();

//        linkedList.add(new Node<>("abc"));
//        linkedList.add(new Node<>("1"));
//        linkedList.printLinkedList(first);
//        Node<String> nodes = linkedList.remove(first, "abc");
//        linkedList.printLinkedList(nodes);

//        String max = LinkedList.max(first);
//        System.out.println(max);
    }
}
