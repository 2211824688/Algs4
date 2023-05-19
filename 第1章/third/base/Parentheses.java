import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * 1.3.4
 */
public class Parentheses {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        In in = new In("file/parentheses.txt");
        String input = in.readString();
        boolean flag = true;
        for (char c : input.toCharArray()) {
            if (c == '[' || c == '{' || c =='(') {
                stack.push(c);
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    flag = false;
                    break;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    flag = false;
                    break;
                }
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    flag = false;
                    break;
                }
            }
        }
        System.out.println(flag);
    }
}
