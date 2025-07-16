import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class TwoSumBSTDFS {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> seen = new HashSet<>();
        return dfs(root, k, seen);
    }

    // DFS traversal
    private boolean dfs(TreeNode node, int k, Set<Integer> seen) {
        // Base case: reached a null node
        if (node == null) return false;

        // Check if complement exists in set
        if (seen.contains(k - node.val)) {
            return true; // Found two numbers that sum to k
        }

        // Add current node's value to the set
        seen.add(node.val);

        // Recursively search left and right subtrees
        return dfs(node.left, k, seen) || dfs(node.right, k, seen);
    }

    public static void main(String[] args) {
        // Build BST: [5,3,6,2,4,null,7]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3, new TreeNode(2), new TreeNode(4));
        root.right = new TreeNode(6, null, new TreeNode(7));

        TwoSumBSTDFS solution = new TwoSumBSTDFS();
        System.out.println(solution.findTarget(root, 9));  // Output: true
    }
}
