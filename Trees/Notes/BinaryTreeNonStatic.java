package Trees.Notes;

public class BinaryTreeNonStatic {
    Node root;

    // Node class as an inner class
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Inorder Traversal method
    void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.left);  // Visit left subtree
        System.out.print(node.data + " ");  // Visit node
        inorder(node.right);  // Visit right subtree
    }

    // Main method to test the binary tree
    public static void main(String[] args) {
        BinaryTreeNonStatic tree = new BinaryTreeNonStatic(); // Correct class name

        // Creating a simple tree
        tree.root = tree.new Node(1);   // Instantiate Node correctly
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);

        // Inorder Traversal
        System.out.println("Inorder Traversal:");
        tree.inorder(tree.root); // Output: 4 2 5 1 3
    }
}
