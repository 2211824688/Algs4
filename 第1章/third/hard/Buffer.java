import edu.princeton.cs.algs4.Stack;

/**
 * 1.3.44
 * 文本编辑器的缓冲区
 */
public class Buffer {
    Stack<Character> stack1, stack2;
    public Buffer() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void insert(char c) {
        stack1.push(c);
    }

    public char delete() {
        if (!stack1.isEmpty()) {
            return stack1.pop();
        } else {
            return ' ';
        }
    }

    public void left(int k) {
        for (int i = 0; i < k; i++) {
            if (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            } else {
                stack2.push(' ');
            }
        }
    }

    public void right(int k) {
        for (int i = 0; i < k; i++) {
            if (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            } else {
                stack1.push(' ');
            }
        }
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        // Test
        // fuck
        Buffer buffer = new Buffer();
        buffer.insert('f');
        buffer.insert('u');
        buffer.insert('c');
        buffer.insert('k');
        buffer.left(2);
        System.out.println(buffer.delete());
    }
}
