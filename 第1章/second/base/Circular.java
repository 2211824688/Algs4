public class Circular {
    /**
     * 1.2.6
     */
    public static boolean isCircularRotation(String s, String t) {
        return s.length() == t.length() && (s + s).contains(t);
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "cab";
        System.out.println(isCircularRotation(s, t));
    }
}
