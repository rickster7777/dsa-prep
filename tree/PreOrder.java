import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class PreOrder {
    private int index = 0; // To keep track of current position in the preorder list

    public TreeNode buildTree(int[] preorder) {
        return buildTreeHelper(preorder);
    }

    private TreeNode buildTreeHelper(int[] preorder) {
        // Check if we have reached the end of the array or encountered -1 (indicating
        // null)
        if (index >= preorder.length || preorder[index] == -1) {
            index++; // Move to the next element
            return null;
        }

        // Create the current node with the value at the current index
        TreeNode node = new TreeNode(preorder[index]);
        index++; // Move to the next element in the preorder list

        // Recursively build the left and right subtrees
        node.left = buildTreeHelper(preorder);
        node.right = buildTreeHelper(preorder);

        return node;
    }

    // Function to print the tree in preorder traversal (for verification)
    public void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " "); // Visit the current node first
            preorderTraversal(root.left); // Then visit the left subtree
            preorderTraversal(root.right); // Then visit the right subtree
        }
    }

    // only below part will differ in case of post, pre and in order traversal.
    // public void inorderTraversal(TreeNode root) {
    // if (root != null) {
    // inorderTraversal(root.left);
    // System.out.print(root.val + " ");
    // inorderTraversal(root.right);
    // }
    // }

    // Post order
    // public void postorderTraversal(TreeNode root) {
    // if (root != null) {
    // postorderTraversal(root.left); // Then visit the left subtree
    // postorderTraversal(root.right); // Then visit the right subtree
    // System.out.print(root.val + " "); // Visit the current node first
    // }
    // }

    // Function to perform level-order traversal
    public void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Dequeue the front element
            TreeNode node = queue.poll();

            // Print the value of the current node
            System.out.print(node.val + " ");

            // Enqueue the left and right children (if they exist)
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public int countOfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftnodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftnodes + rightNodes + 1;
    }

    public static void main(String[] args) {
        PreOrder tree = new PreOrder();

        // Given preorder traversal list
        // int[] preorder = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int[] preorder = { 1, 2, 3, -1, 5 };
        // Build the tree
        TreeNode root = tree.buildTree(preorder);

        // Print preorder traversal to verify the tree structure
        System.out.println("Preorder Traversal: ");
        tree.preorderTraversal(root);
        // tree.inorderTraversal(root);
        // tree.postorderTraversal(root);

        // tree.levelOrderTraversal(root);
        int count = tree.countOfNodes(root);
        System.out.println("\ncount " + count);

    }
}
