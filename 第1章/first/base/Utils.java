public class Utils {
    /**
     * 1.1.14
     */
    public static int lg(int N) throws IllegalAccessException {
        if (N <= 0) {
            throw new IllegalAccessException("N 必须大于0");
        }
        int result = 0;
        while (N > 1) {
            N /= 2;
            result++;
        }
        return result;
    }

    /**
     * 1.1.15
     */
    public static int[] histogram(int[] a, int M) {
        int[] cnt = new int[M];
        for (int i : a) {
            if (i < M) {
                cnt[i]++;
            }
        }
        return cnt;
    }

    /**
     * 1.1.20
     */
    public static double lnOfFactorial(int N) {
        return Math.log(fact(N));
    }
    public static double fact(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fact(n-1);
        }
    }

    /**
     * 1.1.24
     * 欧几里得算法求最大公因数
     */
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
