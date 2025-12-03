package Lab10;

public class numberofnodes  {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v){ val = v; }
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = leftDepth(root);
        int rightHeight = rightDepth(root);

        if (leftHeight == rightHeight)
            return (1 << leftHeight) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static int leftDepth(TreeNode n) {
        int h = 0;
        while (n != null) {
            h++;
            n = n.left;
        }
        return h;
    }

    private static int rightDepth(TreeNode n) {
        int h = 0;
        while (n != null) {
            h++;
            n = n.right;
        }
        return h;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(countNodes(root)); // Output: 6
    }
}
/*
EXPLANATION:

This problem uses the fact that the tree is a COMPLETE binary tree.

leftDepth(root):
    Counts height by repeatedly going to left child.
rightDepth(root):
    Counts height by repeatedly going to right child.

Case 1:
If leftDepth == rightDepth:
    The tree is a PERFECT binary tree.
    Node count = 2^height - 1
    No need to traverse all nodes.

Case 2:
If heights differ:
    Only the last level is incomplete.
    So we recursively count:
        1 + left subtree + right subtree

This makes the algorithm O(log^2 n), faster than a normal traversal.

In main():
The tree has nodes [1,2,3,4,5,6].
The program prints 6.
*/