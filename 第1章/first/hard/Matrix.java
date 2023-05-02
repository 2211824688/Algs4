import java.util.Arrays;

/**
 * 1.1.33
 */
public class Matrix {
    /**
     * 向量点乘
     * @param x vector
     * @param y vector
     * @return  result of dot product
     */
    public static double dot(double[] x, double[] y) {
        assert x.length == y.length : "Both vectors must be the same length";
        double result = 0;
        for (int i = 0; i < x.length; i++) {
            result += x[i]*y[i];
        }
        return result;
    }

    /**
     * 矩阵和矩阵之积
     * @param a matrix
     * @param b matrix
     * @return  product of matrices
     */
    public static double[][] mult(double[][] a, double[][] b) {
        assert a != null : "a must not be null";
        assert b != null : "b must not be null";
        assert a[0].length == b.length : "the columns of a must equal the rows of b";
        int rows = a.length, cols = b[0].length;
        double[][] result = new double[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                double val = 0;
                int n = a[r].length;
                for (int i = 0; i < n; i++) {
                    val += a[r][i]*b[i][c];
                }
                result[r][c] = val;
            }
        }
        return result;
    }

    /**
     * 转置矩阵
     * @param a matrix
     * @return  矩阵的转置
     */
    public static double[][] transpose(double[][] a) {
        if (a.length == 0) {
            return new double[0][0];
        }
        int m = a.length, n = a[0].length;
        double[][] arr = new double[n][m];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                arr[c][r] = a[r][c];
            }
        }
        return arr;
    }

    /**
     * 矩阵和向量之积
     * @param a matrix
     * @param x vector
     * @return  vector
     */
    public static double[] mult(double[][] a, double[] x) {
        assert a[0].length == x.length : "the columns of a must equals x.length";
        double[] result = new double[a.length];
        int i = 0;
        for (double[] vector : a) {
            result[i++] = dot(vector, x);
        }
        return result;
    }

    /**
     * 向量和矩阵之积
     * @param y vector
     * @param a matrix
     * @return  vector
     */
    public static double[] mult(double[] y, double[][] a) {
        assert y.length == a.length : "y.length must equals the rows of a";
        double[] result = new double[a[0].length];
        int i = 0;
        for (int j = 0; j < a[0].length; j++) {
            int val = 0, n = y.length;
            for (int r = 0; r < n; r++) {
                val += y[r]*a[r][j];
            }
            result[i++] = val;
        }
        return result;
    }

    public static void main(String[] args) {
        double[][] mat1 = {
                {1,2,3},
                {2,4,5}
        };
        double[][] mat2 = {
                {1,4},
                {2,6},
                {10,5}
        };
        // dot
        double[] x = {2.5, 1.0, 4.5};
        double[] y = {2.0, 10, 3.0};
        System.out.println(dot(x, y));
        // mat*mat
        System.out.println(Arrays.deepToString(mult(mat1, mat2)));
        // transpose
        System.out.println(Arrays.deepToString(transpose(mat1)));
        // mat*vect
        System.out.println(Arrays.toString(mult(mat1, x)));
        // vect*mat
        double[] vect = {1, 2};
        System.out.println(Arrays.toString(mult(vect, mat1)));
    }
}
