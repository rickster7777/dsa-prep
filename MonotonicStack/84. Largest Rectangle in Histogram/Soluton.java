import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        // Add a zero-height bar at the end to force pop at the end
        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println(sol.largestRectangleArea(heights)); // Output: 10
        /*
         * Input: heights = [2,1,5,6,2,3]
         * Output: 10
         * Explanation: The above is a histogram where width of each bar is 1.
         * The largest rectangle is shown in the red area, which has an area = 10 units.
         */
    }
}
