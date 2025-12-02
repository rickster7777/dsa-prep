import java.util.ArrayList;
import java.util.List;

public class NQueens {

    // This method solves the N-Queens problem and returns ALL possible solutions.
    // Each solution is a list of strings, where each string represents one row of the chessboard.
    public List<List<String>> solveNQueens(int n) {

        // This will store all valid solutions found by backtracking.
        List<List<String>> result = new ArrayList<>();

        // Create an empty NxN chessboard.
        // board[i][j] = '.' means empty square
        // board[i][j] = 'Q' means a queen placed
        char[][] board = new char[n][n];

        // Initialize every cell of the board with '.'
        // Meaning: no queen placed anywhere initially.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        /*
         * We now call the backtracking function.
         * Parameters:
         * result → stores all final solutions
         * board → current state of the chessboard
         * row = 0 → start placing queens from row 0
         * n → size of board
         *
         * boolean arrays help us check conflicts in O(1) time:
         * cols[col] = true  → column has a queen
         * diag1[...] = true → major diagonal has a queen  (r - c)
         * diag2[...] = true → minor diagonal has a queen  (r + c)
         *
         * diag1 and diag2 arrays need size 2*n so indexes don't go negative.
         */
        backtrack(result, board, 0, n, new boolean[n], new boolean[2 * n], new boolean[2 * n]);

        return result;
    }


    // BACKTRACKING FUNCTION:
    // Tries to place a queen on each row, one row at a time.
    private void backtrack(List<List<String>> result, char[][] board, int row, int n,
                boolean[] cols, boolean[] diag1, boolean[] diag2) {

        // BASE CASE:
        // If row == n, we successfully placed queens in all rows.
        if (row == n) {
            // Convert the current board state to a list of strings and add to result.
            result.add(constructBoard(board, n));
            return;
        }

        // Try placing a queen in each column of the current row.
        for (int col = 0; col < n; col++) {

            /*
             * Checking safety:
             *
             * 1. cols[col] checks if same column already has a queen.
             * 2. diag1[row - col + (n - 1)] checks major diagonal.
             *      - major diagonal has equal (row - col)
             *      - add (n - 1) to avoid negative index
             *
             * 3. diag2[row + col] checks minor diagonal.
             *      - minor diagonal has equal (row + col)
             *
             * If any of these is true → placing queen here is unsafe → skip this column.
             */
            if (cols[col] || diag1[row - col + (n - 1)] || diag2[row + col]) {
                continue; // Not safe, try next column
            }

            // PLACE THE QUEEN:
            board[row][col] = 'Q';

            // Mark column and diagonals as occupied.
            cols[col] = true;
            diag1[row - col + (n - 1)] = true;
            diag2[row + col] = true;

            // Move to the next row (recursive call)
            backtrack(result, board, row + 1, n, cols, diag1, diag2);

            // BACKTRACK:
            // Remove the queen and unmark column and diagonals.
            // This allows trying other positions in the current row.
            board[row][col] = '.';
            cols[col] = false;
            diag1[row - col + (n - 1)] = false;
            diag2[row + col] = false;
        }
    }


    // Converts the board (char[][]) into a list of strings.
    // Each row of the board becomes one string.
    private List<String> constructBoard(char[][] board, int n) {
        List<String> boardList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // Convert char array into String
            boardList.add(new String(board[i]));
        }
        return boardList;
    }


    public static void main(String[] args) {

        NQueens solver = new NQueens();
        int n = 4;  // You can change this to any N ≥ 4

        // Solve N-Queens and store all solutions
        List<List<String>> solutions = solver.solveNQueens(n);

        // Print the solutions in a readable format
        System.out.println("Solutions for " + n + "-Queens:");
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println(); // Blank line after each solution
        }
    }
}





/*
Problem Statement

Given an integer N, the task is to place N queens on an N×N chessboard in such a way that:

No two queens share the same row.

No two queens share the same column.

No two queens share the same diagonal.

Constraints:

The problem is solvable for N ≥ 4, but not for N = 2 or N = 3.

The solution should be a placement of queens on the board (i.e., their coordinates or positions).

Backtracking Approach to the N-Queens Problem

Backtracking is a general algorithm for finding all (or some) solutions to computational problems by trying partial solutions and then "backtracking" if the solution is not valid.

In the context of the N-Queens problem, backtracking works by placing queens row by row and checking if each queen placement is safe (i.e., it does not conflict with any already-placed queens). If a conflict arises, the algorithm "backtracks" by removing the last placed queen and trying a different position for it.

How Backtracking Works in N-Queens:

Start at the first row and try to place a queen in each column of that row.

Check if the queen placement is safe (i.e., no two queens threaten each other). A queen is threatened by another queen if:

They are on the same column.

They are on the same diagonal (either main or anti-diagonal).

If placing the queen does not lead to any conflicts, move to the next row and repeat the process.

If all rows are successfully filled with queens, a solution has been found.

If placing a queen leads to a conflict (i.e., no valid position is available for the current queen), backtrack:

Remove the last placed queen and try a new position for it.

Repeat until all rows are considered, or if no solution exists.

Key Idea: Conflict Check

To efficiently check if placing a queen at position (r, c) is safe, we use three conditions:

The column c should not already have a queen.

The major diagonal r - c should not already have a queen.

The minor diagonal r + c should not already have a queen.

We can keep track of these constraints using sets or arrays:

columns: A set to track which columns are occupied.

diag1: A set to track the major diagonals (difference r - c).

diag2: A set to track the minor diagonals (sum r + c).

*/