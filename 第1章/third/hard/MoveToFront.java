import java.util.Scanner;

/**
 * 1.3.40
 */
public class MoveToFront {

    private static final DoubledList<Character> linkedList = new DoubledList<>();
    private static final int[] count = new int[26];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String in = scanner.next();
            Character c = in.charAt(0);
            int idx = c - 'a';
            if (count[idx] > 0) {
                linkedList.delete(c);
            } else {
                count[idx] = 1;
            }
            linkedList.insertFirst(c);
        }
        linkedList.print();
    }
}



