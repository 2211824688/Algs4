import edu.princeton.cs.algs4.Point2D;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.2.1
 */
public class Point2DTest {
    public static void main(String[] args) {
        int N = 10000;
        List<Point2D> points = new ArrayList<>();
        double minDistance = 10.0;
        for (int i = 0; i < N; i++) {
            double x = Math.random();
            double y = Math.random();
            Point2D point2D = new Point2D(x, y);
            point2D.draw();
            for (Point2D point : points) {
                if (point2D.distanceTo(point) < minDistance) {
                    minDistance = point2D.distanceTo(point);
                }
            }
            points.add(point2D);
        }
        System.out.println("min distance: " + minDistance);
    }
}
