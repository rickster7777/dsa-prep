// Definition of a Binary Tree Node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructor to create a node
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    // Stores the maximum diameter found while traversing the tree.
    // Diameter is measured in terms of number of EDGES.
    int diameter = 0;

    /**
     * Returns the diameter of the binary tree.
     *
     * Approach:
     * - Perform a DFS traversal.
     * - While calculating the height of each node,
     *   also compute the longest path passing through that node.
     *
     * Time Complexity : O(n)
     * Space Complexity: O(h)
     *      where h = height of the tree
     */
    public int diameterOfBinaryTree(TreeNode root) {

        // Start DFS traversal.
        height(root);

        // Diameter is updated during recursion.
        return diameter;
    }

    /**
     * Returns the height of the subtree rooted at 'root'.
     *
     * Height = Number of nodes in the longest path
     *          from current node to a leaf.
     *
     * While returning height, this function also updates
     * the global diameter.
     */
    private int height(TreeNode root) {

        // Base case:
        // Height of an empty tree is 0.
        if (root == null) {
            return 0;
        }

        // Recursively calculate left subtree height.
        int left = height(root.left);

        // Recursively calculate right subtree height.
        int right = height(root.right);

        /*
         * Longest path passing through current node:
         *
         *          root
         *         /    \
         *      left   right
         *
         * Number of edges =
         *      left subtree height
         *    + right subtree height
         *
         * Example:
         * left height = 2
         * right height = 3
         *
         * Diameter through current node = 2 + 3 = 5 edges
         */
        diameter = Math.max(diameter, left + right);

        /*
         * Return height of current subtree.
         *
         * Height = 1 (current node)
         *        + maximum(left height, right height)
         */
        return Math.max(left, right) + 1;
    }

    // ---------------------- Driver Code ----------------------

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \
             4   5

        Longest path:
        4 -> 2 -> 1 -> 3

        Number of edges = 3
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution obj = new Solution();

        int ans = obj.diameterOfBinaryTree(root);

        System.out.println("Diameter of Binary Tree = " + ans);
    }
}
/*
Dry Run
For the tree:
        1
       / \
      2   3
     / \
    4   5
| Node | Left Height | Right Height | Diameter Through Node | Global Diameter | Returned Height |
| ---- | ----------: | -----------: | --------------------: | --------------: | --------------: |
| 4    |           0 |            0 |                     0 |               0 |               1 |
| 5    |           0 |            0 |                     0 |               0 |               1 |
| 2    |           1 |            1 |                     2 |               2 |               2 |
| 3    |           0 |            0 |                     0 |               2 |               1 |
| 1    |           2 |            1 |                     3 |               3 |               3 |

Output: Diameter of Binary Tree = 3
The longest path is 4 → 2 → 1 → 3, which contains 3 edges, so the answer is 3.

*/



/*
1 version to calc diameter is present in the Trees -> traversals -> PreOrder.java
but chatgpt verdict

Your approach is logically correct for computing the diameter, but it has two issues:

Time Complexity is O(n²) because HeightOfTree() is called repeatedly for every node.
LeetCode 543 defines the diameter as the number of edges, not the number of nodes. Your code returns the number of nodes on the longest path because of +1.
Why O(n²)?

For every node:

You recursively compute the diameter of the left subtree.
You recursively compute the diameter of the right subtree.
Then you compute the height of the left subtree.
Then you compute the height of the right subtree.

The heights are recalculated many times.
*/