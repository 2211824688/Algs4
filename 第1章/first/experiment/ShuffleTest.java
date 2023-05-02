import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * 1.1.36
 */
public class ShuffleTest {
    private static void initArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
    }
    public static void main(String[] args) {
        int M = 10;
        int N = 1000000;
        int[] arr = new int[M];
        int[][] table = new int[M][M];
        for (int i = 0; i < N; i++) {
            initArray(arr);
            StdRandom.shuffle(arr);
            for (int j = 0; j < M; j++) {
                table[arr[j]][j]++;
            }
        }
        for (int[] row : table) {
            System.out.println(Arrays.toString(row));
        }
    }
}
