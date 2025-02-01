// In order traversal
class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class BinaryTree {
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

    // Function to print the tree in inorder traversal (for verification)
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        // Given preorder traversal list
        int[] preorder = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        
        // Build the tree
        TreeNode root = tree.buildTree(preorder);
        
        // Print inorder traversal to verify the tree structure
        System.out.print("Inorder Traversal: ");
        tree.inorderTraversal(root);
    }
}
