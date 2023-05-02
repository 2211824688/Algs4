public class Solution {
    /**
     * 1.1.27
     * @param N 试验的次数
     * @param k 事件发生的次数
     * @param p 每次试验的成功概率
     * @return
     */
    public static double binomial(int N, int k, double p) {
        double[][] table = new double[N+1][k+1];

        // 初始化第一列
        for (int i = 0; i <= N; i++) {
            table[i][0] = 1.0;
        }

        // 计算表格中的其他值
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= k; j++) {
                table[i][j] = (1.0 - p)*table[i-1][j] + p*table[i-1][j-1];
            }
        }

        return table[N][k];
    }

    /**
     * 1.1.30
     */
    public static boolean[][] createCoprimeArray(int n) {
        boolean[][] result = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Utils.gcd(i, j) == 1) {
                    result[i][j] = true;
                }
            }
        }
        return result;
    }
}
