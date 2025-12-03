package Lab10;

public class InclusiveRange {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v){ val = v; }
    }

    static class Solution {
        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) return 0;
            int s = 0;
            if (root.val >= low && root.val <= high) s += root.val;
            if (root.val > low) s += rangeSumBST(root.left, low, high);
            if (root.val < high) s += rangeSumBST(root.right, low, high);
            return s;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        Solution s = new Solution();
        int low = 7;
        int high = 15;

        int result = s.rangeSumBST(root, low, high);
        System.out.println(result);
    }
}

/*
EXPLANATION:

The tree built in main() represents:
        10
       /  \
      5    15
     / \     \
    3   7     18
You are given a Binary Search Tree
You must sum all node values that fall inside the inclusive range
low ≤ value ≤ high
We call rangeSumBST(root, 7, 15).


So you ONLY add values that are between 7 and 15, including 7 and 15.
rangeSumBST goes through the tree and adds only the values that fall inside [7, 15].

These values are:
7 (from left subtree)
10 (root)
15 (right subtree)

They add up to 32.

The final printed output is: 32

 */