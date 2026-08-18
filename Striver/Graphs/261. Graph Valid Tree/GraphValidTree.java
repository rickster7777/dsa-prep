/*
Problem Statement

You are given:

n → number of nodes labeled from 0 to n - 1
edges → an array where each pair [u, v] represents an undirected edge between nodes u and v.

Your task is to determine whether these nodes form one valid tree.

What is a Tree?

A graph is a valid tree if both conditions are true:

1. The graph is connected

Every node should be reachable from every other node.

There should not be any isolated (disconnected) node.

Example:

0 ----- 1
|       |
2 ----- 3

Every node can reach every other node.

✅ Connected

2. The graph has NO cycle

A cycle means you can start from a node and come back to it without repeating an edge.

Example:

0
| \
|  \
1---2

Cycle:

0 → 1 → 2 → 0

❌ Not a tree

Example 1
Input
n = 5

edges =
[
 [0,1],
 [0,2],
 [0,3],
 [1,4]
]

Graph

      0
    / | \
   1  2  3
   |
   4
Is it connected?

Yes.

Starting from node 0:

0 → 1
0 → 2
0 → 3
1 → 4

All nodes are visited.

✅ Connected

Any cycle?

No.

There is only one path between every pair of nodes.

✅ No Cycle

Output
true

Because it satisfies both conditions.

Example 2
Input
n = 5

edges =
[
 [0,1],
 [1,2],
 [2,3],
 [1,3],
 [1,4]
]

Graph

0
|
1
|\
| \
2--3
|
4

Notice

1 → 2 → 3 → 1

forms a cycle.

Although every node is connected,

❌ A cycle exists.

Output
false
Example 3
Input
n = 5

edges =
[
 [0,1],
 [2,3],
 [3,4]
]

Graph

0 --- 1

2 --- 3 --- 4

There are two separate components.

You cannot go from node 0 to node 4.

❌ Not connected

Output
false
Key Observation

A graph is a valid tree only if:

It has exactly n - 1 edges.
It is fully connected.
It has no cycles.

If any one of these conditions fails, the answer is false.

Why must a tree have exactly n - 1 edges?

Suppose there are 5 nodes.

Less than n - 1 edges
0 --- 1

2 --- 3 --- 4

Edges = 3

Required = 4

The graph is disconnected.

❌ Not a tree

More than n - 1 edges
0
|\
| \
1--2
|
3
|
4

Edges = 5

Required = 4

Extra edges create a cycle.

❌ Not a tree

Exactly n - 1 edges
      0
    / | \
   1  2  3
   |
   4

Edges = 4

Nodes = 5

Connected and no cycle.

✅ Valid Tree

Intuition Behind the Union-Find Solution

As we process each edge:

If two nodes are in different groups, we connect them.
If two nodes are already in the same group, adding another edge creates a cycle, so the graph is not a tree.
Before processing, we also check that the graph has exactly n - 1 edges. If it doesn't, we can immediately return false.
*/
public class GraphValidTree {

    // ============================================================
    // STEP 1: Union-Find (Disjoint Set) Data Structure
    // ============================================================

    static class UnionFind {

        // parent[i] stores the parent of node i
        int[] parent;

        public UnionFind(int n) {

            parent = new int[n];

            // Initially every node is its own parent.
            //
            // Example:
            // parent = [0,1,2,3,4]
            //
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        // ============================================================
        // Find the ultimate parent (root) of a node.
        // Uses Path Compression for optimization.
        // ============================================================
        public int find(int x) {

            // If node is its own parent,
            // then it is the root.
            if (parent[x] == x)
                return x;

            // Path Compression
            parent[x] = find(parent[x]);

            return parent[x];
        }

        // ============================================================
        // Union two nodes.
        //
        // Returns:
        // true  -> Successfully connected.
        // false -> They already belong to same set (cycle found).
        // ============================================================
        public boolean union(int a, int b) {

            int rootA = find(a);
            int rootB = find(b);

            // Both nodes already belong to same component.
            // Adding this edge creates a cycle.
            if (rootA == rootB)
                return false;

            // Merge the two components.
            parent[rootA] = rootB;

            return true;
        }
    }

    // ============================================================
    // Main Function
    // ============================================================
    public static boolean validTree(int n, int[][] edges) {

        // ============================================================
        // STEP 2:
        // A valid tree with n nodes MUST contain exactly n-1 edges.
        // ============================================================
        //
        // If edge count differs,
        // it can never be a valid tree.
        //
        if (edges.length != n - 1)
            return false;

        // ============================================================
        // STEP 3:
        // Create Union-Find structure.
        // ============================================================
        UnionFind uf = new UnionFind(n);

        // ============================================================
        // STEP 4:
        // Process every edge.
        // ============================================================
        //
        // If an edge connects two nodes already connected,
        // then a cycle exists.
        //
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            if (!uf.union(u, v)) {
                return false;
            }
        }

        // ============================================================
        // STEP 5:
        //
        // No cycles found.
        // Since edge count = n-1,
        // graph is automatically connected.
        // ============================================================
        return true;
    }

    // ============================================================
    // Main Method
    // ============================================================
    public static void main(String[] args) {

        // ---------------- Example 1 ----------------
        int n1 = 5;

        int[][] edges1 = {
                {0,1},
                {0,2},
                {0,3},
                {1,4}
        };

        System.out.println("Example 1:");
        System.out.println(validTree(n1, edges1));
        // Expected: true


        // ---------------- Example 2 ----------------
        int n2 = 5;

        int[][] edges2 = {
                {0,1},
                {1,2},
                {2,3},
                {1,3},
                {1,4}
        };

        System.out.println("\nExample 2:");
        System.out.println(validTree(n2, edges2));
        // Expected: false


        // ---------------- Example 3 ----------------
        int n3 = 4;

        int[][] edges3 = {
                {0,1},
                {2,3}
        };

        System.out.println("\nExample 3:");
        System.out.println(validTree(n3, edges3));
        // Expected: false
    }
}

//same class approach

class Solution {

    int[] parent;

    public boolean validTree(int n, int[][] edges) {

        // A tree must have exactly n-1 edges.
        if (edges.length != n - 1)
            return false;

        parent = new int[n];

        // Initialize each node as its own parent.
        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1]))
                return false;
        }

        return true;
    }

    private int find(int x) {

        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    private boolean union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return false;

        parent[rootA] = rootB;

        return true;
    }
}

/*
| Approach   | Time Complexity        | Space    | Interview Preference |
| ---------- | ---------------------- | -------- | -------------------- |
| DFS        | **O(V + E)**           | O(V + E) | ⭐⭐⭐⭐                 |
| BFS        | **O(V + E)**           | O(V + E) | ⭐⭐⭐⭐                 |
| Union-Find | **O(E × α(V)) ≈ O(E)** | O(V)     | ⭐⭐⭐⭐⭐                |

*/