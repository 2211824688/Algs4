import edu.princeton.cs.algs4.BinarySearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EqualInteger {
    /**
     * 1.4.8
     */
    public static int count(int[] arr) {
        int cnt = 0, n = arr.length;
        Arrays.sort(arr);
        for (int value : arr) {
            if (BinarySearch.indexOf(arr, value) > 0) {
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("第1章/fourth/data.txt"));
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(Integer.parseInt(scanner.next()));
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        System.out.println(count(arr));
    }
}
