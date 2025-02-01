package Trees.Notes.Traversals;

import java.util.LinkedList;
import java.util.Queue;

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

    public void InorderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }
        InorderTraversal(root.left);
        System.out.print(root.val + " ");
        InorderTraversal(root.right);
    }

    public void PostOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);
        System.out.print(root.val + " ");
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

    // Function to perform level-order traversal in new line
    public void LevelOrderTraversal(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode currNode = q.remove();

            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.val + " ");

                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }

    }

    // count of nodes
    public int countOfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftnodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftnodes + rightNodes + 1;
    }

    // sum of nodes
    public int sumOfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.val;
    }

    // Height/Level of a tree.

    public int HeightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = HeightOfTree(root.left);
        int rightHeight = HeightOfTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // In here at every step/node 
        // first the complete diameter of left subtree is calculated.
        // Second the complete diameter of right subtree is calculated.
        // Height of left subtree + right subtree  + 1.
        // Max of above.


        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = HeightOfTree(root.left) + HeightOfTree(root.right) + 1;

        return Math.max(diam3, Math.max(diam1, diam2)); 
        //complexity is quadratic o(n^2).
    }

    public static void main(String[] args) {
        PreOrder tree = new PreOrder();

        // Given preorder traversal list
        // int[] preorder = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int[] preorder = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // Build the tree
        TreeNode root = tree.buildTree(preorder);

        // Print preorder traversal to verify the tree structure
        // System.out.println("Preorder Traversal: ");
        // tree.preorderTraversal(root);

        // // Inorder
        // System.out.println("\n\nInorder Traversal: ");
        // tree.InorderTraversal(root);

        // // PostOrder
        // System.out.println("\n\nPostOrder Traversal: ");
        // tree.PostOrderTraversal(root);

        // // LevelOrder
        // System.out.println("\n\nLevelOrder Traversal: ");
        // tree.levelOrderTraversal(root);

        // // LevelOrderTraversal
        // System.out.println("\nLevelOrder Traversal: ");
        // tree.LevelOrderTraversal(root);

        // //Number of nodes
        // System.out.println("\nNumber of nodes in a tree: ");
        // System.out.println(tree.countOfNodes(root));

        // Sum of nodes
        System.out.println("\nSum of nodes in a tree: ");
        System.out.println(tree.sumOfNodes(root));

        // Height/level of tree
        System.out.println("\nHeight of a tree: ");
        System.out.println(tree.HeightOfTree(root));

        //diameter of a tree
        
        System.out.println("\nDiameter of a tree: ");
        System.out.println(tree.diameter(root));

    }
}
