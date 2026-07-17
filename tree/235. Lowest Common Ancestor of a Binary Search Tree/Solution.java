package tree.235. Lowest Common Ancestor of a Binary Search Tree;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}

/*
Case 1: Both p and q are smaller than the current node
        6
       /
      2
     / \
    0   4

If:

p = 0
q = 4

Both values are less than 6, so the LCA must be in the left subtree.

if (p.val < root.val && q.val < root.val)
    root = root.left;
Case 2: Both p and q are greater than the current node
      6
       \
        8
       / \
      7   9

If:

p = 7
q = 9

Both are greater than 6, so move to the right subtree.

if (p.val > root.val && q.val > root.val)
    root = root.right;
Case 3: They split at the current node (or one of them is the current node)
        6
       / \
      2   8

If:

p = 2
q = 8

One is on the left and the other is on the right.

Therefore:

LCA = 6

Another example:

        6
       /
      2
     / \
    0   4

If:

p = 2
q = 4

Here, p is an ancestor of q. Since we've reached 2 and the other node lies below it, the LCA is 2 itself.

This is also covered by the same condition because:

p.val == root.val
One node is not strictly on one side anymore.

So we return root.

Decision Logic
                 root
                  |
     +------------+------------+
     |                         |
 p,q < root?             p,q > root?
     |                         |
    Yes                       Yes
     |                         |
 Go Left                  Go Right
     |
     No
     |
 Return root

The "Return root" case includes both:

p and q are on opposite sides of root.
root is equal to p or q (meaning one node is an ancestor of the other).
Iterative Solution
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
        if (p.val < root.val && q.val < root.val) {
            root = root.left;
        } else if (p.val > root.val && q.val > root.val) {
            root = root.right;
        } else {
            return root;
        }
    }
    return null;
}
Time Complexity
Time: O(h), where h is the height of the BST.
Balanced BST: O(log n)
Skewed BST: O(n)
Space: O(1) for the iterative approach.
*/