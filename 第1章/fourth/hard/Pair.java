import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pair {

    /**
     *1.4.16
     * @param a array
     * @return a中最接近的两个数，如果a的长度小于2返回空
     */
    public static List<Double> findClosestPair(double[] a) {
        List<Double> res = new ArrayList<>();
        double min = Double.MAX_VALUE;
        Arrays.sort(a);
        double v1 = 0, v2 = 0;
        for (int i = 0; i < a.length-1; i++) {
            double val = Math.abs(a[i] - a[i+1]);
            if (val < min) {
                v1 = a[i];
                v2 = a[i+1];
                min = val;
            }
        }
        if (min != Double.MAX_VALUE) {
            res.add(v1);
            res.add(v2);
        }
        return res;
    }

    /**
     * 1.4.17
     * 最遥远的一对
     */

    public static List<Double> findFarthestPair(double[] a) {
        if (a.length < 2) {
            return null;
        } else {
            List<Double> res = new ArrayList<>();
            double max = Double.MIN_VALUE, min = Double.MAX_VALUE;
            for (double d : a) {
                if (d > max) {
                    max = d;
                }
                if (d < min) {
                    min = d;
                }
            }
            res.add(min);
            res.add(max);
            return res;
        }
    }


    public static void main(String[] args) {

        double[] a = {2.0, 1.0, 20.3, 20.9, 20.1, 20.1223, 89, 100, 1000 };

        // test1
        List<Double> ans = findClosestPair(a);
        System.out.println("closest couple:");
        for (Double d : ans) {
            System.out.println(d);
        }

        // test2

        List<Double> list = findFarthestPair(a);
        System.out.println("farthest couple:");
        for (Double d : list) {
            System.out.println(d);
        }

    }
}
