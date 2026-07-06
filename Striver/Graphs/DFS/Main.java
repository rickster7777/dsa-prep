import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // Function to perform DFS traversal
    public void dfs(int v, List<Integer>[] adj, 
                    boolean[] visited, 
                    List<Integer> result) {
        
        // Mark current node as visited
        visited[v] = true;

        // Store node in result
        result.add(v);

        // Traverse all neighbours
        for (int u : adj[v]) {
            if (!visited[u]) {
                dfs(u, adj, visited, result);
            }
        }
    }

    public static void main(String[] args) {
        // Number of vertices
        int V = 5;

        // Adjacency list
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 2));
        adj[1].addAll(Arrays.asList(0, 3));
        adj[2].addAll(Arrays.asList(0, 4));
        adj[3].add(1);
        adj[4].add(2);

        // Visited array
        boolean[] visited = new boolean[V];

        // Result list
        List<Integer> result = new ArrayList<>();

        // Create object
        Solution sol = new Solution();

        // Run DFS from node 0
        sol.dfs(0, adj, visited, result);

        // Print traversal
        for (int x : result) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}


/*

        List<Integer>[] adj = new ArrayList[V];
                              ^
  required: List<Integer>[]
  found:    ArrayList[]


✅ Correct Ways to Fix It
✔️ Option 1: Use type casting (most common workaround)
List<Integer>[] adj = (List<Integer>[]) new ArrayList[V];

👉 This will compile, but gives an unchecked warning. You can suppress it:

@SuppressWarnings("unchecked")
List<Integer>[] adj = (List<Integer>[]) new ArrayList[V];

✔️ Option 2: Initialize each element properly
List<Integer>[] adj = (List<Integer>[]) new ArrayList[V];

for (int i = 0; i < V; i++) {
    adj[i] = new ArrayList<>();
}

✔️ Option 3 (Recommended): Use List<List<Integer>> instead of array

This avoids generics issues entirely:

List<List<Integer>> adj = new ArrayList<>();

for (int i = 0; i < V; i++) {
    adj.add(new ArrayList<>());
}

👉 This is the cleanest and safest approach in modern Java.

🔑 Why This Happens

Java uses type erasure for generics, and arrays are covariant and reified, which makes new List<Integer>[V] unsafe. So Java simply disallows direct creation of generic arrays.

💡 Recommendation

If you're writing graph code (like adjacency lists), prefer:

List<List<Integer>> adj

instead of array-based structures — it's safer and more flexible.

*/