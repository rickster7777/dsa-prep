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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Case 1: both null → same
        if (p == null && q == null) return true;

        // Case 2: one null or values differ → not same
        if (p == null || q == null || p.val != q.val) return false;

        // Case 3: check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

/*
 * non recursive approach

 import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        
        queueP.add(p);
        queueQ.add(q);
        
        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode nodeP = queueP.poll();
            TreeNode nodeQ = queueQ.poll();
            
            if (nodeP == null && nodeQ == null) {
                continue;
            }
            
            if (nodeP == null || nodeQ == null) {
                return false;
            }
            
            if (nodeP.val != nodeQ.val) {
                return false;
            }
            
            queueP.add(nodeP.left);
            queueP.add(nodeP.right);
            
            queueQ.add(nodeQ.left);
            queueQ.add(nodeQ.right);
        }
        
        // Both queues should be empty if trees are same
        return queueP.isEmpty() && queueQ.isEmpty();
    }
}

 */