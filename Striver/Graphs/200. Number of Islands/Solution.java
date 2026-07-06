/*
Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

🎯 Final Group

All these belong to ONE island:

(0,0), (0,1), (0,2), (0,3),
(1,0), (1,1), (1,3),
(2,0), (2,1)
❌ What is NOT part of island

All these are water:

(0,4),
(1,2), (1,4),
(2,2), (2,3), (2,4),
(3,0), (3,1), (3,2), (3,3), (3,4)

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

| Island | Cells        |
| ------ | ------------ |
| 1      | (0,0), (0,1) |
| 2      | (1,2)        |
| 3      | (2,3), (2,4) |

*/
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        // boundary + water check
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
            return;
        }

        // mark visited
        grid[i][j] = '0';

        // explore 4 directions
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        int result = solution.numIslands(grid);
        System.out.println("Number of Islands: " + result); // Output: 3
    }
}