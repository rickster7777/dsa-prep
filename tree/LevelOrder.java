// To perform level-order traversal (also known as breadth-first traversal) on a binary tree in Java, we can use a queue. 
// The idea is to visit nodes level by level, starting from the root and moving downwards.

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

public class LevelOrder {
    private int index = 0; // To keep track of current position in the preorder list
    
    public TreeNode buildTree(int[] preorder) {
        return buildTreeHelper(preorder);
    }
    
    private TreeNode buildTreeHelper(int[] preorder) {
        // Check if we have reached the end of the array or encountered -1 (indicating null)
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

    public static void main(String[] args) {
        LevelOrder tree = new LevelOrder();
        
        // Given preorder traversal list
        int[] preorder = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        
        // Build the tree
        TreeNode root = tree.buildTree(preorder);
        
        // Print level-order traversal to verify the tree structure
        System.out.print("Level-Order Traversal: ");
        tree.levelOrderTraversal(root);
    }
}
