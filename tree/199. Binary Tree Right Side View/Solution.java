/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example 1:

Input: root = [1,2,3,null,5,null,4]

Output: [1,3,4]

Explanation:

Example 2:

Input: root = [1,2,3,4,null,null,null,5]

Output: [1,3,4,5]

Explanation:
how the expected output is [1, 3, 4, 5]
and not [1, 3]

The confusion comes from how the array is interpreted as a binary tree (level-order representation).

Input:

[1,2,3,4,null,null,null,5]

Constructing it level by level:

1 → root
2 → left of 1
3 → right of 1
4 → left of 2
null → right of 2
null → left of 3
null → right of 3
5 → left of 4

So the tree is:

        1
       / \
      2   3
     /
    4
   /
  5

Now look at the tree from the right side.

Level 0
        1

Visible: 1

Level 1
       / \
      2   3

Node 3 blocks 2.

Visible: 3

Level 2
      2   3
     /
    4

There is no node at level 2 on the right subtree (3 has no children).

Since nothing blocks it, 4 is visible from the right.

Visible: 4

Level 3
    4
   /
  5

Again, there is no node to its right.
Visible: 5
So the right-side view is:

[1, 3, 4, 5]
Why not just [1, 3]?

The right-side view means:
At each depth, return the rightmost existing node.
It doesn't mean "only follow the right child."

At each level:

| Level | Nodes | Rightmost Existing |
| ----- | ----- | ------------------ |
| 0     | 1     | **1**              |
| 1     | 2, 3  | **3**              |
| 2     | 4     | **4**              |
| 3     | 5     | **5**              |

Hence the answer is:
[1, 3, 4, 5]

A useful way to visualize it is to imagine standing on the right side of the tree. Even though 5 is in the left subtree,
there are no nodes on its right at the same depth, so it is still visible.


Example 3:

Input: root = [1,null,3]

Output: [1,3]

Example 4:

Input: root = []

Output: []
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            result.add(currentLevel.get(currentLevel.size() - 1));
        }

        return result;

    }

    /*
    This works perfectly, but it uses extra space for currentLevel.

    A slightly cleaner idea is to keep track of the last node during the loop and add it directly to result
    when i == levelSize - 1. This avoids creating a new list for every level.

    Complexity
    Time: O(n) (each node is visited exactly once)
    Space: O(n) (queue in the worst case)

    So your logic is correct, and it should be accepted on LeetCode. The only improvement is a small space optimization
    by eliminating the temporary currentLevel list.
    */

    public List<Integer> rightSideViewOptim(TreeNode root) {

            List<Integer> result = new ArrayList<>();

            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {

                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {

                    TreeNode node = queue.poll();

                    // The last node processed at this level is the rightmost node.
                    if (i == levelSize - 1) {
                        result.add(node.val);
                    }

                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }

            return result;
    }
    public static void main(String[] args) {

    /*
            1
           / \
          2   3
         /
        4
       /
      5

    Input: [1,2,3,4,null,null,null,5]
    Expected Right Side View: [1, 3, 4, 5]
    */

    TreeNode root = new TreeNode(1);

    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(4);

    root.left.left.left = new TreeNode(5);

    Solution obj = new Solution();

    System.out.println(obj.rightSideView(root));
    }
}
