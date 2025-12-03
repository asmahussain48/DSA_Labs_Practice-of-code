package Lab8;

public class InvertBinaryTree {

    // Function to invert the binary tree
    public static Node invertTree(Node root) {
        if (root == null) {
            return null;
        }

        // swap left and right children
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    // Helper: print tree in preorder (Root -> Left -> Right)
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        //root = [4,2,7,1,3,6,9]
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(9);

        System.out.print("Original tree (preorder): ");
        preorder(root);

        invertTree(root);

        System.out.print("\nInverted tree (preorder): ");
        preorder(root);
    }
}
