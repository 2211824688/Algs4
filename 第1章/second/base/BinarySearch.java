import edu.princeton.cs.algs4.Counter;

import java.util.Arrays;

/**
 * 1.2.9
 */

public class BinarySearch {

    /**
     * This class should not be instantiated.
     */
    private BinarySearch() { }

    public static int indexOf(int[] a, int key, Counter counter) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            counter.increment();
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,9,10,20,30};

        // sort the array
        Arrays.sort(arr);

        int key = 100;
        Counter counter = new Counter("BinarySearch Counter");
        int i = indexOf(arr, key, counter);
        if (i == -1) {
            System.out.println("not found");
        } else {
            System.out.println(i);
        }
        System.out.println("counter: " + counter.tally());
    }
}
