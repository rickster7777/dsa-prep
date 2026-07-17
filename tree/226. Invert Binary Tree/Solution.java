
import java.util.Queue;
import java.util.ArrayDeque;
/*
Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    TreeNode root;
    

    // Recursive approach to invert a binary tree
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    //iterative approach to invert a binary tree
    public TreeNode invertTreeIter(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Swap children
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Add children to queue
            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return root;
    }

    // Helper method to print the tree in level-order for verification
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            sb.append(current.val).append(",");

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        // Remove the last comma and add closing bracket
        sb.setLength(sb.length() - 1);
        sb.append("]");
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage:
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode invertedRoot = solution.invertTreeIter(root);
        // You can implement a method to print the tree in order to verify the output.
        printLevelOrder(invertedRoot);
    }
}
/*

invertTree(4)
│
├── invertTree(2)
│   │
│   ├── invertTree(1)
│   │   ├── invertTree(null) → null
│   │   ├── invertTree(null) → null
│   │   └── swap(null, null)
│   │       Tree remains:
│   │           1
│   │
│   ├── invertTree(3)
│   │   ├── invertTree(null) → null
│   │   ├── invertTree(null) → null
│   │   └── swap(null, null)
│   │       Tree remains:
│   │           3
│   │
│   └── swap children of 2
│       before:
│           2
│          / \
│         1   3
│
│       after:
│           2
│          / \
│         3   1
│
├── invertTree(7)
│   │
│   ├── invertTree(6)
│   │   ├── null
│   │   ├── null
│   │   └── returns 6
│   │
│   ├── invertTree(9)
│   │   ├── null
│   │   ├── null
│   │   └── returns 9
│   │
│   └── swap children of 7
│       before:
│           7
│          / \
│         6   9
│
│       after:
│           7
│          / \
│         9   6
│
└── swap children of 4
    before:
           4
         /   \
        2     7
       / \   / \
      3  1  9  6

    after:
           4
         /   \
        7     2
       / \   / \
      9  6  3  1


      Tree After Each Important Step
Initially
        4
      /   \
     2     7
    / \   / \
   1   3 6   9
After inverting subtree rooted at 2
        4
      /   \
     2     7
    / \   / \
   3   1 6   9
After inverting subtree rooted at 7
        4
      /   \
     2     7
    / \   / \
   3   1 9   6
After inverting the root 4
        4
      /   \
     7     2
    / \   / \
   9   6 3   1
Final Output

Level-order traversal of the inverted tree:

[4,7,2,9,6,3,1]
 */
