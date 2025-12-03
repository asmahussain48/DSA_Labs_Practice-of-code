package Lab9;

import Lab9.Node;

public class BSTSearchSubtree {

    // Search for a node with value == val
    public static Node searchBST( Node root, int val) {
        if (root == null)
            return null;

        if (root.value == val)
            return root;

        if (val < root.value)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);

        int val = 3;
        Node result = searchBST(root, val);

        if (result != null)
            System.out.println("Subtree root found with value: " + result.value);
        else
            System.out.println("Value not found in the BST.");
    }
}
