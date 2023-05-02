import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 1.1.38
 */
public class BruteForceSearch {
    public static int indexOf(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test
        int N = 500000000;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = 2*i + 1;
        }
        Stopwatch timer1 = new Stopwatch();
        int index1 = BruteForceSearch.indexOf(arr, 100);
        System.out.println("BruteForceSearch result: " + index1);
        System.out.println("BruteForceSearch time: " + timer1.elapsedTime() + "s");

        Stopwatch timer2 = new Stopwatch();
        int index2 = BinarySearch.indexOf(arr, 100);
        System.out.println("BinarySearch result: " + index2);
        System.out.println("BinarySearch time: " + timer2.elapsedTime() + "s");
    }
}
