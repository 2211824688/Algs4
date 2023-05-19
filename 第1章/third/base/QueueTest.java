import edu.princeton.cs.algs4.Queue;

import java.util.Scanner;

/**
 * 1.3.15
 */
public class QueueTest {
    public static void main(String[] args) {
        int k = 3;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Queue<Character> queue = new Queue<>();
        for (char c : str.toCharArray()) {
            queue.enqueue(c);
        }
        while (queue.size() > k) {
            queue.dequeue();
        }
        System.out.println(queue.peek());
    }
}
