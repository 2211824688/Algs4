/**
 * 1.1.9
 */
public class Convert {
    public static String toBinaryString(int N) {
        StringBuilder s = new StringBuilder();
        for (int n = N; n > 0; n /= 2) {
            s.append(n % 2);
        }
        return s.reverse().toString();
    }
}
