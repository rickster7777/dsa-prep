// const isSafe = (x, y, n, visited, m) => {
//     if ((x >= 0 && x < n) && (y >= 0 && y < n) && (visited[x][y] === 0) && m[x][y] === 1) {
//         return true;
//     }
//     else {
//         return false;
//     }
// }

// const solve = (m, n, ans, x, y, visited, path) => {

//     //Base case
//     if ((x === n - 1) && (y === n - 1)) {
//         ans.push(path)
//         return;
//     }

//     visited[x][y] = 1;

//     // 4 choices

//     //down
//     let newx = x + 1;
//     let newy = y;
//     if (isSafe(newx, newy, n, visited, m)) {
//         path += "D";
//         solve(m, n, ans, x, y, visited, path);
//         path = path.slice(0, -1);

//     }

//     //left
//     newx = x;
//     newy = y - 1;
//     if (isSafe(newx, newy, n, visited, m)) {
//         path += "L";
//         solve(m, n, ans, x, y, visited, path);
//         path = path.slice(0, -1);

//     }

//     //right
//     newx = x;
//     newy = y + 1;
//     if (isSafe(newx, newy, n, visited, m)) {
//         path += "R";
//         solve(m, n, ans, x, y, visited, path);
//         path = path.slice(0, -1);

//     }


//     //up
//     newx = x - 1;
//     newy = y;
//     if (isSafe(newx, newy, n, visited, m)) {
//         path += "U";
//         solve(m, n, ans, x, y, visited, path);
//         path = path.slice(0, -1);

//     }
//     visited[x][y] = 0;
// }

// const findpath = (m, n) => {

//     const ans = [];

//     if (m[0][0] == 0) {
//         return ans;
//     }

//     let srcx = 0;
//     let srcy = 0;

//     const visited = m;

//     for (let i = 0; i < n; i++) {
//         for (let j = 0; j < n; j++) {
//             visited[i][j] = 0;
//         }
//     }

//     let path = "";

//     solve(m, n, ans, srcx, srcy, visited, path);

//     // (a, b) => (a - b)
//     ans.sort();
//     console.log(ans);
// };

// const m = [
//     [1, 0, 0, 0],
//     [1, 1, 0, 1],
//     [1, 1, 0, 0],
//     [0, 1, 1, 1]
// ];

// const n = 4;

// findpath(m, n);

const isSafe = (x, y, n, visited, m) => {
    return x >= 0 && x < n && y >= 0 && y < n && visited[x][y] === 0 && m[x][y] === 1;
}

const solve = (m, n, ans, x, y, visited, path) => {
    // Base case: if (x, y) is the destination (bottom-right corner)
    if (x === n - 1 && y === n - 1) {
        ans.push(path);
        return;
    }

    visited[x][y] = 1; // Mark the current cell as visited

    // 4 possible directions (Down, Left, Right, Up)
    // 1. Move Down (x+1, y)
    if (isSafe(x + 1, y, n, visited, m)) {
        solve(m, n, ans, x + 1, y, visited, path + "D"); // Move Down
    }

    // 2. Move Left (x, y-1)
    if (isSafe(x, y - 1, n, visited, m)) {
        solve(m, n, ans, x, y - 1, visited, path + "L"); // Move Left
    }

    // 3. Move Right (x, y+1)
    if (isSafe(x, y + 1, n, visited, m)) {
        solve(m, n, ans, x, y + 1, visited, path + "R"); // Move Right
    }

    // 4. Move Up (x-1, y)
    if (isSafe(x - 1, y, n, visited, m)) {
        solve(m, n, ans, x - 1, y, visited, path + "U"); // Move Up
    }

    visited[x][y] = 0; // Backtrack: unmark the current cell as visited
}

const findpath = (m, n) => {
    const ans = [];

    // If the starting point is blocked, return empty array
    if (m[0][0] === 0) {
        return ans;
    }

    // Create visited matrix initialized to 0 (unvisited)
    const visited = Array.from({ length: n }, () => Array(n).fill(0));

    // Initialize path as empty string
    let path = "";

    // Start the recursive search from (0, 0)
    solve(m, n, ans, 0, 0, visited, path);

    // Sort the resulting paths lexicographically
    ans.sort();

    console.log(ans);
};

// Test example
const m = [
    [1, 0, 0, 0],
    [1, 1, 0, 1],
    [1, 1, 0, 0],
    [0, 1, 1, 1]
];

const n = 4;

findpath(m, n);  // Should output the possible paths from top-left to bottom-right



/**
 Issues:
Passing the wrong parameters: In the recursive call, you're using the same (x, y) as the starting point for each direction (Down, Left, Right, Up). 
However, you need to pass the new coordinates after the move.

Incorrect path reversal: In your recursive calls, you're using the wrong parameters when passing to the recursive function. You should pass 
the updated x and y coordinates (after moving) instead of the original x and y.

Visited matrix: You're using visited = m which means you're modifying the original maze matrix directly. This can lead to unintended changes 
in the maze. Instead, initialize a separate visited matrix.

Sorting paths: After finding all possible paths, you want to sort them. Sorting strings of paths is fine, but you should be consistent with 
the data type and order.
 */

/** 
Key Changes:
Safe check (isSafe): The function isSafe checks if the current move is valid by ensuring the cell is within bounds, not yet visited, 
and not blocked (m[x][y] === 1).

Visited Matrix: A new visited matrix is created for each recursive call to track which cells have already been visited.

Recursive Calls: The function solve properly handles recursive calls by updating the coordinates and passing the correct path 
with direction letters ("D", "L", "R", "U").

Backtracking: After each move, the path is updated, and the cell is marked as unvisited when backtracking.

Sorting the Result: The resulting paths are sorted lexicographically before output.
 */