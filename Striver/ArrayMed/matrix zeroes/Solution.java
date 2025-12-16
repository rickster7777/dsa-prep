/*
Perform these five steps to get the optimised solution.

Step 1️⃣ Check if first row has any zero.
Step 2️⃣ Check if first column has any zero.
Step 3️⃣ Use first row & column as markers
Step 4️⃣ Zero out cells based on markers
Step 5️⃣ Zero first row / column if needed
*/

public class Solution {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Step 1️⃣ Check if first row has any zero
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step 2️⃣ Check if first column has any zero
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Step 3️⃣ Use first row & column as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 4️⃣ Zero out cells based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5️⃣ Zero first row if needed
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 5️⃣ Zero first column if needed
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }


    public static void main(String[] args) {

        //int[][] matrix = new int{{1,1,1},{1,0,1},{1,1,1}};

        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};


        Solution.setZeroes(matrix);
        System.out.println(java.util.Arrays.deepToString(matrix));
    }
}
