//package 230. Kth Smallest Element in a BST;

import java.util.ArrayList;
import java.util.Collections;
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

class Solution {
    // recursive
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorderHelper(root, list, k);
        return list.get(k-1);
    }

    public void inorderHelper(TreeNode root, List<Integer> list, int k) {
        if (root == null)
            return;

        inorderHelper(root.left, list, k);
        list.add(root.val);

        if (list.size() >= k){
            return;
        }
        inorderHelper(root.right, list,k);
    }

    //iterative
    public int kthSmallestIter(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            list.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        Collections.sort(list);
        return list.get(k-1);
    }

    public static void main(String[] args) {

        // Construct the following BST:
        //
        //          5
        //        /   \
        //       3     7
        //      / \   / \
        //     2   4 6   8
        //
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        Solution sol = new Solution();

        // Inorder Traversal: 2, 3, 4, 5, 6, 7, 8
        System.out.println("k = 1 : " + sol.kthSmallest(root, 1));      // 2
        System.out.println("k = 3 : " + sol.kthSmallest(root, 3));      // 4
        System.out.println("k = 5 : " + sol.kthSmallest(root, 5));      // 6
        System.out.println("k = 7 : " + sol.kthSmallest(root, 7));      // 8

        System.out.println();

        System.out.println("Iterative:");
        System.out.println("k = 1 : " + sol.kthSmallestIter(root, 1));  // 2
        System.out.println("k = 3 : " + sol.kthSmallestIter(root, 3));  // 4
        System.out.println("k = 5 : " + sol.kthSmallestIter(root, 5));  // 6
        System.out.println("k = 7 : " + sol.kthSmallestIter(root, 7));  // 8
    }
}