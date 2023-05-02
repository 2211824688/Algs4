import java.util.Random;

/**
 * 1.1.35
 */
public class Dice {
    private static double[] calcProbability() {
        int SIDES = 6;
        double[] dist = new double[2*SIDES + 1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++) {
                dist[i+j] += 1.0;
            }
        }
        for (int k = 2; k <= 2*SIDES; k++) {
            dist[k] /= 36.0;
        }
        return dist;
    }

    public static void main(String[] args) {
        double[] dist = calcProbability();
        System.out.println("accurate results:");
        for (int i = 2; i <= 12; i++) {
            System.out.println(i + " ----> " + dist[i]);
        }
        double[] exper = new double[13];
        double N = 10000000.0;
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            int x = random.nextInt(6) + 1;
            int y = random.nextInt(6) + 1;
            exper[x+y] += 1.0;
        }
        for (int i = 2; i <= 12; i++) {
            exper[i] /= N;
        }
        System.out.println("the result of experiment:");
        for (int i = 2; i <= 12; i++) {
            System.out.println(i + " ----> " + exper[i]);
        }
    }
}
