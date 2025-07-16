class TreeNode {
    constructor(val, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

function findTarget(root, k) {
    const seen = new Set();

    function dfs(node) {
        // Base case: if node is null, return false
        if (!node) return false;

        // If the complement exists in the set, we found our answer
        if (seen.has(k - node.val)) {
            return true;
        }

        // Add current node's value to the set
        seen.add(node.val);

        // Recursively check left and right subtrees
        return dfs(node.left) || dfs(node.right);
    }

    return dfs(root);
}

// Build BST: [5,3,6,2,4,null,7]
const root = new TreeNode(5);
root.left = new TreeNode(3, new TreeNode(2), new TreeNode(4));
root.right = new TreeNode(6, null, new TreeNode(7));

console.log(findTarget(root, 9));  // Output: true




/*

| Feature                           | Inorder Traversal + Two Pointers                                          | DFS + HashSet                                                     |
| --------------------------------- | ------------------------------------------------------------------------- | ----------------------------------------------------------------- |
| **Idea**                          | Traverse BST in-order to get sorted array, then use 2-pointer to find sum | Traverse tree directly using DFS and use a set to find complement |
| **Steps**                         | 1. Inorder traversal to list<br>2. Use two pointers                       | 1. DFS traversal<br>2. Store seen values in set                   |
| **Extra Data Structure**          | List of all values (`O(n)` space)                                         | HashSet to store seen values (`O(n)` space)                       |
| **Sorted Order Used?**            | Yes, relies on BST inorder being sorted                                   | No, doesn’t rely on ordering                                      |
| **Search Technique**              | Two pointers in sorted array                                              | Set lookup (complement check)                                     |
| **Time Complexity**               | `O(n)`                                                                    | `O(n)`                                                            |
| **Space Complexity**              | `O(n)` for array                                                          | `O(n)` for set                                                    |
| **Tree Traversal Method**         | Recursive Inorder                                                         | Recursive DFS                                                     |
| **Number of Passes Over Tree**    | 1 pass (inorder) + 1 pass (two pointer loop)                              | Single DFS pass                                                   |
| **Short-circuit on Early Match?** | No, needs full traversal first                                            | Yes, can return early if match is found during DFS                |
| **Efficient for Large Trees?**    | Less efficient if early match exists                                      | More efficient if pair found early in DFS                         |
| **Modifies Original Tree?**       | No                                                                        | No                                                                |

*/