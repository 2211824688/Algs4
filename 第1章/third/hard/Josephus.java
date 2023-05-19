import java.util.Scanner;

/**
 * 1.3.37
 */
public class Josephus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }
        int cnt = 1;
        while (!queue.isEmpty()) {
            if (cnt == M) {
                System.out.print(queue.dequeue() + " ");
                cnt = 1;
            } else {
                queue.enqueue(queue.dequeue());
                cnt++;
            }
        }
    }
}
