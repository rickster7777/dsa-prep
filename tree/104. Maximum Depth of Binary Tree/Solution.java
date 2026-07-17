import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0; // Base case: empty tree → depth 0

        // Recursively find depth of left and right subtrees
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // Max depth is max of left/right + 1 (for current node)
        return Math.max(left, right) + 1;
    }

    //Iterative approach
    public int maxDepthIter(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root); // Start with root
        int depth = 0;

        // Traverse level by level
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of nodes at current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // Remove from front of queue
                if (node.left != null) queue.offer(node.left);   // Add left child
                if (node.right != null) queue.offer(node.right); // Add right child
            }
            depth++; // Finished one level
        }

        return depth;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Max Depth (Recursive): " + solution.maxDepth(root)); // Output: 3
        System.out.println("Max Depth (Iterative): " + solution.maxDepthIter(root)); // Output: 3
    }
}

/*
Here linkedList can also be used whats difference that makes.
Queue<TreeNode> queue = new ArrayDeque<>();

1️⃣ Both are valid as a Queue
Queue<TreeNode> q1 = new LinkedList<>();  // ✅ works
Queue<TreeNode> q2 = new ArrayDeque<>();  // ✅ works
Both implement the Queue interface.
Both can do:
    offer() → add to tail
    poll() → remove from head
    peek() → look at head
Both maintain FIFO order.

So in terms of functionality, you can use either.

| Feature                  | LinkedList                                                | ArrayDeque                            |
| ------------------------ | --------------------------------------------------------- | ------------------------------------- |
| **Underlying structure** | Doubly-linked list                                        | Resizable array                       |
| **Memory usage**         | Higher (node objects + pointers)                          | Lower (array only)                    |
| **Cache locality**       | Poor (nodes scattered in memory)                          | Good (contiguous memory)              |
| **Performance**          | O(1) add/remove at ends (but more object allocation)      | O(1) amortized for add/remove at ends |
| **Null elements**        | Allowed                                                   | **Not allowed**                       |
| **Thread safety**        | ❌ (not synchronized)                                      | ❌ (not synchronized)                  |
| **Best use case**        | When you need frequent insertions/deletions in the middle | General-purpose queue/stack, BFS/DFS  |

*/