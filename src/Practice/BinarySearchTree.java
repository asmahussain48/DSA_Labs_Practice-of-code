package Practice;


import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node insertIntoBST( Node root , int val ) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.data) {
            root.left = insertIntoBST(root.left, val); // Insert into left subtree
        } else {
            root.right = insertIntoBST(root.right, val); // Insert into right subtree
        }

        return root;
    }
    public static boolean searchBST(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (root.data == val) {
            return true;
        }
        if (val < root.data) {
            return searchBST(root.left, val);   // search in left subtree
        } else {
            return searchBST(root.right, val);  // search in right subtree
        }
    }

    Node deleteNode(Node root, int key) {
        // Base case: empty tree
        if (root == null) {
            return null;
        }
        // Search for the node
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            // ==== Found the node to be deleted ====

            // Case 1: No child (leaf node)
            if (root.left == null && root.right == null) {
                return null; // Java GC will free it later
            }

            // Case 2: One child (only right)
            else if (root.left == null) {
                return root.right;
            }

            // Case 2: One child (only left)
            else if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            else {
                // Find smallest in right subtree (in-order successor)
                Node succ = findMin(root.right);
                // Copy its value into current node
                root.data = succ.data;
                // Delete that successor node from the right subtree
                root.right = deleteNode(root.right, succ.data);
            }
        }

        return root;
    }

    Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }




    // Level Order Traversal (Breadth-First)
    public static void levelOrder(Node root) {
        if (root == null) return;

        Queue<BinarySearchTree.Node> q = new LinkedList<>();
        q.add(root);
        q.add(null); // Marks end of level

        while (!q.isEmpty()) {
            BinarySearchTree.Node curr = q.remove();
            if (curr == null) {
                System.out.println(); // New line for next level
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }


    public static void main(String[] args) {
        Node root = null;
        int values[] = {5, 3, 7, 2, 4, 6, 8};

        for (int val : values) {
            root = insertIntoBST(root, val);
        }

        System.out.println("Inorder Traversal of BST:");
        levelOrder(root);
    }
}

