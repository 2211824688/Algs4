/**
 * 1.3.32
 */
public class Steque<Item> {
    private final DoubledList<Item> doubledList;

    public Steque() {
        doubledList = new DoubledList<>();
    }

    public void push(Item item) {
        doubledList.insertFirst(item);
    }

    public Item pop() {
        return doubledList.removeFirst();
    }

    public void enqueue(Item item) {
        doubledList.insertLast(item);
    }

    public boolean isEmpty() {
        return doubledList.isEmpty();
    }

    public static void main(String[] args) {
        Steque<String> stringSteque = new Steque<>();
        stringSteque.enqueue("abc");
        stringSteque.enqueue("def");
        stringSteque.enqueue("ghi");
        stringSteque.enqueue("jkl");
        stringSteque.push("hello world");
        while (!stringSteque.isEmpty()) {
            System.out.println(stringSteque.pop());
        }
    }
}
