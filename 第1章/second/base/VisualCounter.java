import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.2.10
 */

public class VisualCounter implements Comparable<VisualCounter> {

    private final int N, max;     // counter max operations and max value
    private int count = 0;         // current value
    private int operateCount = 0;

    public VisualCounter(int N, int max) {
        assert max >= 0 : "max must be greater than or equal to zero";
        assert N >= 0 : "operations must be greater than or equal to zero";
        this.N  = N;
        this.max = max;
        StdDraw.setXscale(0, max);
        StdDraw.setYscale(-N, N);
        StdDraw.line(0, 0, 0, -N);
        StdDraw.line(0, 0, max, 0);
    }

    public void increment() {
        if (operateCount < N && count < max) {
            count++;
            operateCount++;
            draw();
        }
    }

    public void decrement() {
        if (operateCount < N && count > -max) {
            count--;
            operateCount++;
            draw();
        }
    }

    private void draw() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(StdDraw.mouseX(), count+1, Integer.toString(count));
    }

    public int tally() {
        return count;
    }

    public String toString() {
        return count + "";
    }

    @Override
    public int compareTo(VisualCounter that) {
        return Integer.compare(this.count, that.count);
    }


    public static void main(String[] args) {
        int maxCount = 10;
        int maxN = 100;
        VisualCounter counter = new VisualCounter(maxCount, maxN);

        for (int i = 0; i < maxN; i++) {
            if (StdRandom.bernoulli(0.5)) {
                counter.increment();
            } else {
                counter.decrement();
            }
        }
    }
}