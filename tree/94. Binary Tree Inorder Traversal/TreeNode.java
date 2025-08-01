
import java.util.*;


/// * Definition for a binary tree node.
public class TreeNode {
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


// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();

//         if (root != null) {
//             inorderTraversal(root.left);
//             list.add(root.val);
//             inorderTraversal(root.right);
//         }

//         return list;
//     }
// }

// You're very close! The code you posted for inorder traversal is almost correct, but there's a subtle and important bug.
// ❗Problem:
// You are creating a new list list in each recursive call, but you're not passing it along — so the additions in recursive calls are not accumulated.



/*
 ✅ Corrected Code (Recursive Inorder Traversal)
Here’s how to fix it:

✅ Option 1: Use a helper function to pass the list down the recursion
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderHelper(root, list);
        return list;
    }

    private void inorderHelper(TreeNode node, List<Integer> list) {
        if (node == null) return;

        inorderHelper(node.left, list);
        list.add(node.val);
        inorderHelper(node.right, list);
    }
}

/*
✅ Option 2: Use a class-level list (less common)
This works, but it’s less ideal in real-world scenarios because:

It retains state between method calls.

It’s not thread-safe.

🧠 Tip for Interviews
Always think about what gets passed in recursion, and where your result is getting stored. Java passes objects by reference, so if 
you mutate the list directly (by passing it in), it’ll accumulate correctly.

class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }
}
 */