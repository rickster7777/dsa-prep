/*
✅ 1. Two Arrays (Prefix/Suffix Max) — O(n) time, O(n) space
Steps:
Build leftMax[]: max height from left to current index.
Build rightMax[]: max height from right to current index.
For each index i, compute min(leftMax[i], rightMax[i]) - height[i] (if positive), and add to result.


✅ 2. Two Pointers — O(n) time, O(1) space
Idea: You don’t need two full arrays. You can just keep track of:
leftMax as you move from left
rightMax as you move from right

Steps:
Start with two pointers: left = 0, right = n - 1
Track leftMax, rightMax
Move the pointer that has the smaller wall, and calculate trapped water accordingly

Why this works: Because water is trapped based on the shorter of the two sides.


✅ When to Use Stack Approach?
It’s great for interview questions where the problem needs one-pass logic with a monotonic stack.
Slightly harder to write and debug compared to the two-pointer method.


🧱 Stack-Based Approach — O(n) Time, O(n) Space
✅ Core Idea:
We use a stack to keep track of indices of increasing height bars.

When we find a bar taller than the top of the stack, it means:
We can now trap water between the current bar and the bar below the top of the stack.
The top of the stack acts as the bottom of the container.


 */

import java.util.Stack;

class Solution {

    //1st approach
    public int prefixTrap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill leftMax
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Fill rightMax
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate trapped water
        int trapped = 0;
        for (int i = 0; i < n; i++) {
            trapped += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return trapped;

    }

    // 2nd approach
    public int trap(int[] height) {
        int left = 0, right = height.length - 1; // Two pointers
        int leftMax = 0, rightMax = 0; // Track the highest bars from left and right
        int trapped = 0; // Total amount of water trapped

        // Move the pointers toward each other
        while (left < right) {
            // Compare the height at both ends
            if (height[left] < height[right]) {
                // If current height is greater than or equal to leftMax, update leftMax
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // Water can be trapped, difference between leftMax and current height
                    trapped += leftMax - height[left];
                }
                left++; // Move left pointer to the right
            } else {
                // If current height is greater than or equal to rightMax, update rightMax
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // Water can be trapped on this side
                    trapped += rightMax - height[right];
                }
                right--; // Move right pointer to the left
            }
        }

        return trapped; // Total trapped water
    }
    //3rd approach
    public int trapStackApproach(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        int n = height.length;

        for (int i = 0; i < n; i++) {
            // While current height is greater than height at stack's top
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop(); // This is the bottom

                if (stack.isEmpty()) break;

                int distance = i - stack.peek() - 1; // Width between left and right walls
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];

                if (boundedHeight > 0) {
                    water += distance * boundedHeight;
                }
            }

            // Push current index to stack
            stack.push(i);
        }

        return water;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int result = sol.trap(height);
        System.out.println(result);
    }
}



/*
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
6 units of rain water (blue section) are being trapped.

 */