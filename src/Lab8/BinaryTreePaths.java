package Lab8;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static List<String> binaryTreePaths(Node root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        allPaths(root, String.valueOf(root.data), ans);
        return ans;
    }

    private static void allPaths(Node root, String path, List<String> ans) {
        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }
        if (root.left != null) {
            allPaths(root.left, path + "->" + root.left.data, ans);
        }
        if (root.right != null) {
            allPaths(root.right, path + "->" + root.right.data, ans);
        }
    }

    public static void main(String[] args) {
        //tree [1,2,3,null,5]
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);

        List<String> paths = binaryTreePaths(root);
        System.out.println(paths);   //["1->2->5", "1->3"]

        //root = [1]
        Node root2 = new Node(1);
        System.out.println(binaryTreePaths(root2));  //["1"]
    }
}
