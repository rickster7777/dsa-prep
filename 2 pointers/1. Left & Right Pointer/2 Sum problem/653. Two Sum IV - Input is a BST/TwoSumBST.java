import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class TwoSumBST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);

        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum == k) return true;
            else if (sum < k) left++;
            else right--;
        }

        return false;
    }

    private void inorder(TreeNode node, List<Integer> nums) {
        // Base case for the recursion.
        if (node == null) return;

        // Recursively traverse the left subtree it goes all the way down to the leftmost node.
        inorder(node.left, nums);

        // Visit the current node and add its value to the nums list.
        nums.add(node.val);

        // Recursively traverse the right subtree.
        inorder(node.right, nums);
    }

    /*
    Traverse left subtree of 5 → Node 3 → Node 2 (no left child)
        Visit 2 → add 2
        Backtrack to 3, visit 3 → add 3
        Visit right of 3 → Node 4 → add 4
        Backtrack to 5 → add 5
        Visit right of 5 → Node 6 → add 6
     */
    public static void main(String[] args) {
        // BST: [5,3,6,2,4,null,7]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        TwoSumBST solver = new TwoSumBST();
        System.out.println(solver.findTarget(root, 9));  // Output: true
    }
}

/*
       5
     / \
    3   6
   / \   \
  2   4   7

 */