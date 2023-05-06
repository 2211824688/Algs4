import edu.princeton.cs.algs4.BinarySearch;

public class Main {

    public static String mystery(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        String a = s.substring(0, n/2);
        String b = s.substring(n/2, n);
        return a + b;
    }

}
