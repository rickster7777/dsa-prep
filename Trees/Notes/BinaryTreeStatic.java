package Trees.Notes;

public class BinaryTreeStatic {
    // Root of the binary tree
    Node root;

    // Node class defined as static
    public static class Node {
        int data;
        Node left, right;

        // Constructor for Node
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Method for Inorder Traversal
    public void inorder(Node node) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree first
        inorder(node.left);

        // Then print the data of the node
        System.out.print(node.data + " ");

        // Finally, traverse the right subtree
        inorder(node.right);
    }

    // Helper method to start the inorder traversal from the root
    public void inorderTraversal() {
        inorder(root);
    }

    // Main method to test the BinaryTreeStatic class and inorder traversal
    public static void main(String[] args) {
        // Create a BinaryTreeStatic instance
        BinaryTreeStatic tree = new BinaryTreeStatic();

        // Now, you can directly create Node instances without needing a BinaryTreeStatic instance
        tree.root = new Node(1);  // Root node
        tree.root.left = new Node(2);  // Left child of root
        tree.root.right = new Node(3);  // Right child of root
        tree.root.left.left = new Node(4);  // Left child of node 2
        tree.root.left.right = new Node(5);  // Right child of node 2

        // Print the inorder traversal of the binary tree
        System.out.println("Inorder Traversal:");
        tree.inorderTraversal();  // Output: 4 2 5 1 3
    }
}
