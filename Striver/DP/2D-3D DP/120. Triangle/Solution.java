
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10

*/

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;


        for (int i = 0; i < triangle.size(); i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < triangle.get(i).size(); j++) {
                min = Math.min(min, triangle.get(i).get(j));
            }

            sum += min;
        }
        return sum;
    }

    // My above sol missed this condition.
    /*
    For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may 
    move to either index i or index i + 1 on the next row
    */

    public static void main(String[] args) {
        // Create the triangle as List<List<Integer>>
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        
        Solution sol = new Solution();
        System.out.println(sol.minimumTotal(triangle));
    }
}
