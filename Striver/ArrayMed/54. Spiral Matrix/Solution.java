/*
54. Spiral Matrix
Medium
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100


✅ Core Approach: Boundary Traversal

We maintain four pointers:
top → starting row
bottom → ending row
left → starting column
right → ending column

We traverse the matrix layer by layer in spiral order.

🔁 Traversal Order (Clockwise)
Left → Right across the top row
Top → Bottom down the right column
Right → Left across the bottom row (if valid)
Bottom → Top up the left column (if valid)

After each step, shrink the boundary.

🧠 Visual Example
Matrix:
1   2   3
4   5   6
7   8   9

Traversal: → → → ↓ ↓ ← ← ↑

Result: [1, 2, 3, 6, 9, 8, 7, 4, 5]
*/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        // Continue until all boundaries cross
        while (top <= bottom && left <= right) {

            // 1. Traverse from Left to Right
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // 2. Traverse from Top to Bottom
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            // 3. Traverse from Right to Left (check if still valid)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // 4. Traverse from Bottom to Top (check if still valid)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> spiralOrder = sol.spiralOrder(matrix);
        System.out.println(spiralOrder); // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}



/*
⏱️ Complexity Analysis

Time: O(m × n)

Space: O(1) (excluding output list)

🔥 Common Mistakes to Avoid

❌ Forgetting boundary checks (top <= bottom, left <= right)
❌ Double-counting elements
❌ Hardcoding square matrix logic (this works for any m × n)

🏆 Interview Tip

Say this clearly:

“We use four pointers to track boundaries and shrink them after each spiral layer.”

*/