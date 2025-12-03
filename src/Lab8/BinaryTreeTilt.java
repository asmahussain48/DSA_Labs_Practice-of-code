package Lab8;


public class BinaryTreeTilt {
    static int result = 0;

    public static int findTilt(Node root) {
        helper(root);
        return result;
    }

    private static int helper(Node root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        result += Math.abs(left - right);

        return left + right + root.data;
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        System.out.println("Example 1 Output: " + findTilt(root1)); // 1

        result = 0;

        Node root2 = new Node(4);
        root2.left = new Node(2);
        root2.right = new Node(9);
        root2.left.left = new Node(3);
        root2.left.right = new Node(5);
        root2.right.right = new Node(7);
        System.out.println("Example 2 Output: " + findTilt(root2)); // 15
    }
}
