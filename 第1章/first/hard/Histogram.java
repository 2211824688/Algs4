import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.1.32
 */
public class Histogram {
    public static void main(String[] args)
    {
        int N = 50;
        double l = 0.0;
        double r = 1.0;
        double [] a = new double[1000];
        for (int i = 0; i < a.length ; i++)
        {
            a[i] = StdRandom.uniformDouble();
        }
        double dx = (r-l) / N;//每一段的长度
        int [] count = new int [N];
        for (double v : a) {
            double distance = v - l;//每个数与起始端的距离
            int x = (int) (distance / dx);
            count[x]++;
        }
        int max = count[0];//画出风采!
        for (int i = 0; i < N; i++)
        {
            if (max < count[i])
                max = count[i];
        }
        StdDraw.setYscale(0,max+1);
        StdDraw.setXscale(l,r+0.5);
        for (int i = 0; i < N; i++)
        {
            StdDraw.filledRectangle(i*dx+0.2, count[i]/2.0, dx/2,count[i]/2.0 );
        }
    }
}
