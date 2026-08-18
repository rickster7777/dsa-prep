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
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
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

/*
This is also called as flood-fill algo
Here's a summary of what we've learned so far, without jumping ahead.

Problem Goal

Given a grid:

1 = Land
0 = Water

Count the number of separate islands.

Two land cells belong to the same island only if they are connected up, down, left, or right.

Diagonal connections do not count.

Example:

1 1 0 0
1 0 0 1
0 0 1 1

This grid has 2 islands:

Island 1:
(0,0), (0,1), (1,0)

Island 2:
(1,3), (2,3), (2,2)
Why do we use DFS?

When the outer loop finds a land cell ('1'), we don't immediately count it and move on.

Instead, we call:

dfs(grid, i, j);

because we want to:

Explore every connected land cell of that island.
Mark all of them as visited by changing '1' to '0'.
Count the island only once.
Why mark visited cells as '0'?

Suppose we visit (0,0).

We do:

grid[0][0] = '0';

Now if DFS reaches (0,0) again from another direction, it sees:

grid[0][0] == '0'

and immediately returns.

This prevents:

counting the same island multiple times
infinite recursion between neighboring land cells
The Base Case

Every DFS call starts with:

if (i < 0 || j < 0 ||
    i >= m || j >= n ||
    grid[i][j] == '0') {
    return;
}

DFS returns when:

the coordinates are outside the grid
the cell is water
the cell has already been visited (also '0')
Order of Exploration

Each land cell explores its neighbors in this order:

dfs(i + 1, j); // Down
dfs(i - 1, j); // Up
dfs(i, j + 1); // Right
dfs(i, j - 1); // Left

DFS always follows one direction completely before trying the next.

Why is it called Depth-First Search?

Because it goes as deep as possible in one direction before coming back.

Example:

dfs(0,0)
    ↓
dfs(1,0)
    ↓
dfs(2,0)
    ↓
return
    ↑
dfs(1,0)
    ↑
dfs(0,0)

It explores deeply, then backtracks.

Call Stack So Far

We traced the first island like this:

dfs(0,0)
    │
    └── dfs(1,0)
            │
            ├── dfs(2,0) → return (water)
            ├── dfs(0,0) → return (visited)
            ├── dfs(1,1) → return (water)
            └── dfs(1,-1) → return (out of bounds)

After dfs(1,0) finishes, execution goes back to dfs(0,0), which continues with its remaining directions (Up, Right, Left).

The Most Important Mindset

Don't think:

"What is the whole algorithm doing?"

Instead, for every recursive call, ask:

Which cell am I trying to visit?
Does the base case make me return?
If not, mark it as visited.
Explore all four directions.
When done, return to the previous call (backtracking).

If you keep this mindset, recursion becomes much easier to follow because you're only reasoning about one function call at a time,
not the entire recursion tree.

*/