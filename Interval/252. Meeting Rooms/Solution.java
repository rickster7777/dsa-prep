/*
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person can attend all meetings.

Return:

true if no meetings overlap.
false if any two meetings overlap.

Example 1

Input
intervals = [[0,30],[5,10],[15,20]]

Output
false

Example 2

Input

intervals = [[7,10],[2,4]]

Output
true

Example 3

Input
intervals = [[1,2],[2,3],[3,4]]

Output
true

Example 4

Input
intervals = [[1,3],[2,4],[5,6]]

Output
false

Constraints
1 <= intervals.length <= 10^4
0 <= starti < endi <= 10^6
*/

public class Solution {
    public static boolean meeting(int[][] intervals) {

        java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int currentInterval = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < currentInterval) {
                return false;
            }

            currentInterval = intervals[i][1];
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] intervals1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println(meeting(intervals1)); // Output: false

        int[][] intervals2 = { { 7, 10 }, { 2, 4 } };
        System.out.println(meeting(intervals2)); // Output: true

        int[][] intervals3 = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
        System.out.println(meeting(intervals3)); // Output: true

        int[][] intervals4 = { { 1, 3 }, { 2, 4 }, { 5, 6 } };
        System.out.println(meeting(intervals4)); // Output: false
    }
}
