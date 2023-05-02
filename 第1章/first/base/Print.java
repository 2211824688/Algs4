import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Print {
    /**
     * 1.1.11
     * @param arr  boolean array
     */
    public static void printBooleanArray(boolean[][] arr) {
        int n = arr.length;
        StdOut.print("  ");
        for (int i = 0; i < n; i++) {
            StdOut.print(i + " ");
        }
        StdOut.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    StdOut.print(i + " ");
                }
                if (arr[i][j]) {
                    StdOut.print("*");
                } else {
                    StdOut.print(" ");
                }
                StdOut.print(" ");
            }
            StdOut.println();
        }
    }

    /**
     * 1.1.13
     */
    public static <T> void printArrayTranspose(T [][] arr) {
        if (arr.length < 1) {
            return;
        }
        int m = arr.length, n = arr[0].length;
        for (int col = 0; col < n; col++) {
            for (T[] t : arr) {
                StdOut.print(t[col] + " ");
            }
            StdOut.println();
        }
    }

    /**
     * 1.1.21
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("file/data.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String name = scanner.next();
            int v1 = scanner.nextInt(), v2 = scanner.nextInt();
            StdOut.printf("%-4s\t%d\t%d\t%.3f", name, v1, v2, (double)v1/v2);
            StdOut.println();
        }
    }
}
