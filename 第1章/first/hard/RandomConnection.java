import edu.princeton.cs.algs4.StdDraw;

/**
 * 1.1.31
 */
public class RandomConnection {
    public static void main(String[] args) {
        int N = 10;
        double p = 0.2;

        // 设置画布大小和范围
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setScale(-1, N);

        // 绘制圆和点
        double centerX = (N - 1) / 2.0;
        double centerY = (N - 1) / 2.0;
        double radius = N / 2.0;
        StdDraw.circle(centerX, centerY, radius);
        for (int i = 0; i < N; i++) {
            double angle = 2 * Math.PI * i / N;
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            StdDraw.point(x, y);
        }

        // 绘制连接
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (Math.random() < p) {
                    double x1 = centerX + radius * Math.cos(2 * Math.PI * i / N);
                    double y1 = centerY + radius * Math.sin(2 * Math.PI * i / N);
                    double x2 = centerX + radius * Math.cos(2 * Math.PI * j / N);
                    double y2 = centerY + radius * Math.sin(2 * Math.PI * j / N);
                    StdDraw.line(x1, y1, x2, y2);
                }
            }
        }
    }
}
