package Trees.Notes;


// Abstract base class for Binary Tree
abstract class AbstractApproach {
    // Root of the binary tree (can be set by subclass)
    Node root;

    // Abstract method to define inorder traversal (will be implemented in concrete class)
    public abstract void inorderTraversal();

    // Inner Node class
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Inorder traversal implementation
    protected void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left); // Traverse left subtree
        System.out.print(node.data + " "); // Visit node
        inorder(node.right); // Traverse right subtree
    }
}

// Concrete class that extends AbstractApproach
class ConcreteBinaryTree extends AbstractApproach {

    // Implement the inorder traversal for this specific tree
    @Override
    public void inorderTraversal() {
        inorder(root);
    }

    // Method to create the tree (setting root and nodes)
    public void createTree() {
        root = new Node(1);  // Root node
        root.left = new Node(2);  // Left child of root
        root.right = new Node(3);  // Right child of root
        root.left.left = new Node(4);  // Left child of node 2
        root.left.right = new Node(5);  // Right child of node 2
    }
}

public class AbstractTreeExample {
    public static void main(String[] args) {
        // Create an instance of the concrete class
        ConcreteBinaryTree tree = new ConcreteBinaryTree();

        // Create the tree structure
        tree.createTree();

        System.out.println("Inorder Traversal:");
        tree.inorderTraversal();  // Output: 4 2 5 1 3
    }
}
