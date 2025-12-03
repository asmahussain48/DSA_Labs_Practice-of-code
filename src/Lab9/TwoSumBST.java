package Lab9;

class treeNode {
    int val;
    treeNode left, right;

    treeNode( int val) {
        this.val = val;
    }
}

public class TwoSumBST {

    int[] visited = new int[100];
    int index = 0;

    public boolean findTarget( treeNode root, int k) {
        return dfs(root, k);
    }

    private boolean dfs( treeNode node, int k) {
        if (node == null)
            return false;

        for (int i = 0; i < index; i++) {
            if (visited[i] == k - node.val)
                return true;
        }

        visited[index++] = node.val;

        return dfs(node.left, k) || dfs(node.right, k);
    }

    public static void main(String[] args) {

        treeNode root = new treeNode(5);
        root.left = new treeNode(3);
        root.right = new treeNode(6);
        root.left.left = new treeNode(2);
        root.left.right = new treeNode(4);
        root.right.right = new treeNode(7);

        TwoSumBST t = new TwoSumBST();

        System.out.println(t.findTarget(root, 9));   // true
        System.out.println(t.findTarget(root, 28));  // false
    }
}
