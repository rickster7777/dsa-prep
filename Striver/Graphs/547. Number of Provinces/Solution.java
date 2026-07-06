class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int[][] graph, boolean[] visited, int city) {
        visited[city] = true;

        for (int j = 0; j < graph.length; j++) {
            if (graph[city][j] == 1 && !visited[j]) {
                dfs(graph, visited, j);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        int result = solution.findCircleNum(isConnected);
        System.out.println("Number of Provinces: " + result); // Output: 2
    }
}