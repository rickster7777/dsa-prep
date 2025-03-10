package lcd.containerwater;


class Solution {
    public int maxArea(int[] height) {
        int start = 0; // Left pointer
        int end = height.length - 1; // Right pointer
        int maxArea = 0; // Stores the maximum area found

        while (start < end) {
            // Calculate the width between the two pointers
            int width = end - start;

            // Find the minimum height between the two bars
            int minHeight = Math.min(height[start], height[end]);

            // Calculate the area of the container
            int area = width * minHeight;

            // Update maxArea if a larger area is found
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter height inward
            if (height[start] < height[end]) {
                start++; // Move left pointer
            } else {
                end--; // Move right pointer
            }
        }

        return maxArea; // Return the maximum area found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(height1)); // Output: 49

        int[] height2 = {1, 1};
        System.out.println(solution.maxArea(height2)); // Output: 1
    }
}
