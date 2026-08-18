/*
Step 1  : Store directions
Step 2  : Get rows and columns
Step 3  : Create Pacific and Atlantic visited arrays
Step 4  : Run DFS from Pacific borders (Top + Left)
Step 5  : Run DFS from Atlantic borders (Bottom + Right)
Step 6  : Find intersection of both visited arrays
Step 7  : Return answer

DFS:
Step 8  : Base case (already visited)
Step 9  : Mark current cell visited
Step 10 : Explore 4 directions
Step 11 : Skip out-of-bound cells
Step 12 : Skip neighbors with smaller height (reverse DFS rule)
Step 13 : Recursive DFS call
Step 14 : Backtrack (return after exploring all neighbors)
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    // Step 1:
    // Store the four possible directions:
    // Up, Down, Left, Right
    private final int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        // Step 2:
        // Get the number of rows and columns.
        int rows = heights.length;
        int cols = heights[0].length;

        // Step 3:
        // Create two visited matrices.
        // pacific[r][c]  -> Cell can reach Pacific.
        // atlantic[r][c] -> Cell can reach Atlantic.
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // ---------------------------------------------------------
        // Step 4:
        // Start Reverse DFS from the Pacific Ocean.
        //
        // Pacific touches:
        // 1. Top Row
        // 2. Left Column
        // ---------------------------------------------------------

        // Top Row
        for (int col = 0; col < cols; col++) {
            dfs(0, col, heights, pacific);
        }

        // Left Column
        for (int row = 0; row < rows; row++) {
            dfs(row, 0, heights, pacific);
        }

        // ---------------------------------------------------------
        // Step 5:
        // Start Reverse DFS from the Atlantic Ocean.
        //
        // Atlantic touches:
        // 1. Bottom Row
        // 2. Right Column
        // ---------------------------------------------------------

        // Bottom Row
        for (int col = 0; col < cols; col++) {
            dfs(rows - 1, col, heights, atlantic);
        }

        // Right Column
        for (int row = 0; row < rows; row++) {
            dfs(row, cols - 1, heights, atlantic);
        }

        // ---------------------------------------------------------
        // Step 6:
        // Find the intersection.
        //
        // A cell is part of the answer only if
        // it is reachable from BOTH oceans.
        // ---------------------------------------------------------

        List<List<Integer>> answer = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (pacific[row][col] && atlantic[row][col]) {
                    answer.add(Arrays.asList(row, col));
                }
            }
        }

        // Step 7:
        // Return the final answer.
        return answer;
    }

    // This DFS is a Preorder DFS. ✅
    private void dfs(int row,
                     int col,
                     int[][] heights,
                     boolean[][] visited) {

        // ---------------------------------------------------------
        // Step 8:
        // Base Case:
        // If already visited, stop.
        // ---------------------------------------------------------
        if (visited[row][col]) {
            return;
        }

        // ---------------------------------------------------------
        // Step 9:
        // Mark the current cell as visited.
        // ---------------------------------------------------------
        visited[row][col] = true;

        // ---------------------------------------------------------
        // Step 10:
        // Explore all four directions.
        // ---------------------------------------------------------
        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // -----------------------------------------------------
            // Step 11:
            // Ignore cells that are outside the grid.
            // -----------------------------------------------------
            if (newRow < 0 || newRow >= heights.length ||
                newCol < 0 || newCol >= heights[0].length) {
                continue;
            }

            // -----------------------------------------------------
            // Step 12:
            // Reverse DFS Rule:
            //
            // We can move only if
            // neighbor height >= current height.
            //
            // Otherwise skip this neighbor.
            // -----------------------------------------------------
            if (heights[newRow][newCol] < heights[row][col]) {
                continue;
            }

            // -----------------------------------------------------
            // Step 13:
            // Visit the valid neighbor.
            // -----------------------------------------------------
            dfs(newRow, newCol, heights, visited);
        }

        // ---------------------------------------------------------
        // Step 14:
        // All four directions are processed.
        // Function returns (Backtracking).
        // ---------------------------------------------------------
    }

    public static void main(String[] args) {

        // Step 1:
        // Create the input matrix.
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        // Step 2:
        // Create the Solution object.
        Solution solution = new Solution();

        // Step 3:
        // Call the function.
        List<List<Integer>> answer = solution.pacificAtlantic(heights);

        // Step 4:
        // Print the answer.
        System.out.println("Cells that can reach both oceans:");

        for (List<Integer> cell : answer) {
            System.out.println(cell);
        }
    }
}