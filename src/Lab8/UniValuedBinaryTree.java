package Lab8;

public class UniValuedBinaryTree {

    public static boolean isUnivalTree(Node root) {
        if (root == null) {
            return true;
        }
        return checkUnival(root, root.data);
    }
    private static boolean checkUnival(Node root, int value) {
        if (root == null) {
            return true;
        }
        if (root.data != value) {
            return false;
        }
        return checkUnival(root.left, value) && checkUnival(root.right, value);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(1);
        root1.right = new Node(1);
        root1.left.left = new Node(1);
        root1.left.right = new Node(1);
        root1.left.left.left = new Node(1);
        root1.left.right.right = new Node(1);
        System.out.println("Example 1: " + isUnivalTree(root1));
        Node root2 = new Node(2);
        root2.left = new Node(2);
        root2.right = new Node(2);
        root2.left.left = new Node(5);
        root2.left.right = new Node(2);

        System.out.println("Example 2: " + isUnivalTree(root2)); // false
    }
}
