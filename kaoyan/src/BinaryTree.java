class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int val) {
        TreeNode newNode = new TreeNode(val);

        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode current = root;
        while (true) {
            if (val < current.val) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }
}