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


class Solution {

    // Stores the previously visited node during inorder traversal.
    // Since inorder of a BST should be strictly increasing,
    // every current node must have a value greater than prev.
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode node) {

        // Base case:
        // An empty tree (or subtree) is always a valid BST.
        if (node == null) {
            return true;
        }

        // Step 1: Traverse the left subtree.
        // If the left subtree is invalid, immediately return false.
        if (!inorder(node.left)) {
            return false;
        }

        // Step 2: Process the current node.
        // Since we're performing inorder traversal,
        // the current node's value must be greater than the
        // previously visited node's value.
        if (prev != null && prev.val >= node.val) {
            return false;
        }

        // Update prev to the current node before moving right.
        prev = node;

        // Step 3: Traverse the right subtree.
        return inorder(node.right);


        /*
        Above line is equivalent to writing

        if (!inorder(node.right)) {
            return false;
        }

        return true;
        */
    }


    //Iterative approach
    public boolean isValidBSTIter(TreeNode root) {

        // Initially every value is allowed.
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {

        // Empty subtree is always valid.
        if (node == null) {
            return true;
        }

        // Current node must lie within the allowed range.
        //
        // min < node.val < max
        //
        // We use <= and >= because duplicates are not allowed in a BST.
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Left subtree:
        // Values must be smaller than the current node.
        boolean left = validate(node.left, min, node.val);

        // Right subtree:
        // Values must be greater than the current node.
        boolean right = validate(node.right, node.val, max);

        return left && right;
    }

    public static void main(String[] args) {

        // ---------------- Valid BST ----------------
        //
        //          5
        //        /   \
        //       3     7
        //      / \   / \
        //     2   4 6   8
        //
        TreeNode validRoot = new TreeNode(5);
        validRoot.left = new TreeNode(3);
        validRoot.right = new TreeNode(7);
        validRoot.left.left = new TreeNode(2);
        validRoot.left.right = new TreeNode(4);
        validRoot.right.left = new TreeNode(6);
        validRoot.right.right = new TreeNode(8);

        Solution s1 = new Solution();
        System.out.println("Valid BST (Inorder): " + s1.isValidBST(validRoot));

        // Create a new Solution object because 'prev' retains state.
        Solution s2 = new Solution();
        System.out.println("Valid BST (Min-Max): " + s2.isValidBSTIter(validRoot));


        // ---------------- Invalid BST ----------------
        //
        //          5
        //        /   \
        //       3     7
        //            /
        //           4
        //
        // 4 is in the right subtree of 5,
        // but 4 < 5, so this is NOT a BST.
        //
        TreeNode invalidRoot = new TreeNode(5);
        invalidRoot.left = new TreeNode(3);
        invalidRoot.right = new TreeNode(7);
        invalidRoot.right.left = new TreeNode(4);

        Solution s3 = new Solution();
        System.out.println("Invalid BST (Inorder): " + s3.isValidBST(invalidRoot));

        Solution s4 = new Solution();
        System.out.println("Invalid BST (Min-Max): " + s4.isValidBSTIter(invalidRoot));
    }

}


/*
Why use long instead of int?

Suppose the root contains:

Integer.MIN_VALUE

If we also use int for the lower bound, there's no smaller integer to represent negative infinity.

Using:

Long.MIN_VALUE
Long.MAX_VALUE

ensures that every possible int value fits safely inside the allowed range.
 */

/*
!inorder(node.left)) {
            return false;
How this will check valid and invalid
then why its not done in case of node.right

Great question. The reason is that we're using early termination.

This means:
1. Validate the entire left subtree.
2. If the left subtree is not a valid BST, there is no point checking the current node or the right subtree.
3. Immediately return false.


Case 1: Left subtree is valid

Example:

      5
     / \
    3   7
   / \
  2   4

Call stack:

inorder(5)
    ↓
inorder(3)
    ↓
inorder(2)

At node 2:

inorder(null) -> true
process 2
inorder(null) -> true

returns true

Back to node 3:

if (!inorder(node.left))

becomes

if (!true)

which is

if (false)

So we don't return.

We continue checking node 3.

Case 2: Left subtree is invalid

Example:

      5
     /
    3
   /
  4

Inorder becomes:

4, 3

which is decreasing.

At node 3:

prev = 4
current = 3

prev.val >= current.val
4 >= 3

So

return false;

Now go back to the parent (5):

if (!inorder(node.left))

becomes

if (!false)

which is

if (true)

Therefore,

return false;

The algorithm stops immediately because we've already proved the tree isn't a BST.

Why don't we write the same thing for the right subtree?

Notice the code:

if (!inorder(node.left)) {
    return false;
}

// check current node

return inorder(node.right);

The last line is simply:

return inorder(node.right);

This already does exactly what you think.

If the right subtree returns: true then return true;

If the right subtree returns: false then return false;
*/