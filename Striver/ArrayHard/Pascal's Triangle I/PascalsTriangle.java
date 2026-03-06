import java.util.ArrayList;
import java.util.List;

/**
 * Utility class demonstrating two ways to generate Pascal's Triangle.
 *
 * 1) `PascalsTriangleList(int n)` builds the triangle as a List of rows
 *    where each row is a List<Integer>. This representation is useful when
 *    you need random access to previous rows or need to return the triangle
 *    as a data structure.
 *
 * 2) `PascalsTriangle(int n)` prints the triangle to stdout using the
 *    multiplicative formula for binomial coefficients. It computes each
 *    element in a row iteratively from the previous element using the
 *    identity: C(i, j+1) = C(i, j) * (i - j) / (j + 1), which avoids
 *    computing factorials and stays in integer arithmetic for small n.
 */
public class PascalsTriangle {

    /**
     * Build Pascal's Triangle as a list of integer lists and print it.
     *
     * Approach:
     * - Create an outer List `triangle` to hold rows.
     * - For each row index i from 0..n-1:
     *   - Start a new row and add the leading 1.
     *   - For positions j = 1..i-1, compute value as sum of two numbers
     *     directly above from the previous row: triangle[i-1][j-1] + triangle[i-1][j].
     *   - If i > 0 add the trailing 1 (every row except the first has a trailing 1).
     * - Append the completed row to `triangle`.
     *
     * Time complexity: O(n^2) time to generate n rows of the triangle.
     * Space complexity: O(n^2) to store all rows.
     *
     * @param n number of rows to generate
     */
    public static void PascalsTriangleList(int n) {

        List<List<Integer>> triangle = new ArrayList<>();

        // Generate each row one by one
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            // Every row starts with 1
            row.add(1);

            // For internal elements (not the first or last), each is the sum
            // of the two elements above it from the previous row.
            for (int j = 1; j < i; j++) {
                row.add(triangle.get(i - 1).get(j - 1) +
                        triangle.get(i - 1).get(j));
            }

            // Every row except the very first ends with 1
            if (i > 0)
                row.add(1);

            triangle.add(row);
        }

        // Print the complete triangle structure (debug / demonstration)
        System.out.println(triangle);
    }

    /**
     * Print Pascal's Triangle using the multiplicative binomial coefficient formula.
     *
     * This method prints rows formatted with leading spaces to look like a triangle.
     * It computes each entry from the previous one to avoid factorials:
     *   C(i,0) = 1
     *   C(i,j+1) = C(i,j) * (i - j) / (j + 1)
     * Using integer arithmetic is safe here for small i because the divisions
     * are exact at each step.
     *
     * Example: for row i = 4 the sequence of coefficients is 1,4,6,4,1.
     *
     * @param n number of rows to print
     */
    public static void PascalsTriangle(int n) {
        for (int i = 0; i < n; i++) {
            int number = 1; // first number in a row is always 1 (C(i,0))

            // Print leading spaces to visually center the triangle.
            for (int space = 0; space < n - i; space++) {
                System.out.print(" ");
            }

            // Generate and print the binomial coefficients for row i
            for (int j = 0; j <= i; j++) {
                // Print current coefficient
                System.out.print(number + " ");
                // Update to next coefficient using multiplicative formula:
                // number = number * (i - j) / (j + 1)
                // This computes C(i, j+1) from C(i, j)
                number = number * (i - j) / (j + 1);
            }

            // Move to next line after finishing the row
            System.out.println();
        }
    }

    /**
     * Simple demo `main` showing both methods for n = 6.
     * You can change `n` to print/store more or fewer rows.
     */
    public static void main(String[] args) {

        int n = 6; // number of rows

        // Print a nicely formatted triangle
        PascalsTriangle(n);
        // Build and print the list-of-lists representation
        PascalsTriangleList(n);

    }
}