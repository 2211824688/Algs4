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

    /**
     * 1.3.47
     */
    public static <Item> Steque<Item> Catenation(Steque<Item> s1, Steque<Item> s2) {
        Steque<Item> steque = new Steque<>();
        while (!s1.isEmpty()) {
            steque.enqueue(s1.pop());
        }
        while (!s2.isEmpty()) {
            steque.enqueue(s2.pop());
        }
        return steque;
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
