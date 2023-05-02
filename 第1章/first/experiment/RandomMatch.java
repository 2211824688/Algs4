import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * 1.1.39
 */
public class RandomMatch {
    private static int test(int N) {
        int[] nums1 = new int[N];
        int[] nums2 = new int[N];
        for (int i = 0; i < N; i++) {
            nums1[i] = StdRandom.uniformInt(999999) + 1;
            nums2[i] = StdRandom.uniformInt(999999) + 1;
        }
        Arrays.sort(nums2);
        int cnt = 0;
        for (int num : nums1) {
            int index = BinarySearch.indexOf(nums2, num);
            if (index != -1) {
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int T = 10;
        int cnt1 = 0;
        for (int i = 0; i < T; i++) {
            cnt1 += test(1000);
        }
        int cnt2 = 0;
        for (int i = 0; i < T; i++) {
            cnt2 += test(10000);
        }
        int cnt3 = 0;
        for (int i = 0; i < T; i++) {
            cnt3 += test(100000);
        }
        int cnt4 = 0;
        for (int i = 0; i < T; i++) {
            cnt4 += test(1000000);
        }
        int a = cnt1/T;
        int b = cnt2/T;
        int c = cnt3/T;
        int d = cnt4/T;
        System.out.println("1000 ----> " + a);
        System.out.println("10000 ----> " + b);
        System.out.println("100000 ----> " + c);
        System.out.println("1000000 ----> " + d);
    }
}
