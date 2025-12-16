/*
The "Leaders in an Array" problem is a classic algorithmic problem, often seen in competitive programming or technical interviews.
The task is to find all the leaders in an array.
A leader is an element in the array that is strictly greater than all the elements to its right.

Problem Description:
You are given an array of integers. Your goal is to find all the leaders in this array.
A leader is an element that is greater than all the elements to its right. If there is no element to its right
(i.e., the element is the last one), it is always a leader.

Example:
Input:
arr = [16, 17, 4, 3, 5, 2]

Output:
[17, 5, 2]

Explanation:
17 is greater than all elements to its right.
5 is greater than all elements to its right (after 3).
2 is always a leader as it’s the last element in the array.

Approach:
1. Start by considering the last element as a leader, since it has no elements to its right.
2. Traverse the array from right to left.
3. Keep track of the maximum element encountered so far. If the current element is greater than this maximum, it's a leader.
4. Collect all leaders in a list and return them.

Time Complexity:
The time complexity of this approach is O(n), where n is the size of the array, because we only traverse the array once.
*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> findLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int n = arr.length;

        // Start from the last element, which is always a leader
        int maxFromRight = arr[n - 1];
        leaders.add(maxFromRight);

        // Traverse the array from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                leaders.add(arr[i]);
                maxFromRight = arr[i];
            }
        }

        // Since we traversed from right to left, we need to reverse the list
        Collections.reverse(leaders);

        return leaders;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = { 16, 17, 4, 3, 5, 2 };

        List<Integer> leaders = solution.findLeaders(arr);
        System.out.println(leaders); // Output: [17, 5, 2]
    }
}
