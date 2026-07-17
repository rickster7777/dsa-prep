/*
Given an array of meeting time intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required to hold all the meetings.

Two meetings can use the same room if one meeting ends at or before the other starts.

Example 1

Input

intervals = [[0,30],[5,10],[15,20]]

Output 2

Example 2

Input

intervals = [[7,10],[2,4]]

Output 1

Example 3

Input

intervals = [[1,5],[2,6],[4,8]]

Output3

Example 4

Input

intervals = [[1,2],[2,3],[3,4]]

Output: 1


Example 5

Input

intervals = [[1,4],[2,5],[7,9]]

Output: 2

Constraints
1 <= intervals.length <= 10^4
0 <= starti < endi <= 10^6
*/

import java.util.PriorityQueue;

public class Solution {

    public static int meetingRoomsII(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort intervals by start time
        java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap to track the earliest ending meeting time
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // If current meeting starts at or after the earliest ending meeting,
            // we can reuse that room
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            // Add the current meeting's end time
            pq.add(intervals[i][1]);
        }

        // The size of the heap represents the number of rooms needed
        return pq.size();
    }

    public static void main(String[] args) {

        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println(meetingRoomsII(intervals)); // Output: 2

        int[][] intervals1 = { { 7, 10 }, { 2, 4 } };
        System.out.println(meetingRoomsII(intervals1)); // Output: 1

        int[][] intervals2 = { { 1, 5 }, { 2, 6 }, { 4, 8 } };
        System.out.println(meetingRoomsII(intervals2)); // Output: 3

        int[][] intervals3 = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
        System.out.println(meetingRoomsII(intervals3)); // Output: 1

        // above sol fails for this condition
        int[][] intervals4 = { { 1, 5 }, { 2, 6 }, { 5, 10 } };
        System.out.println(meetingRoomsII(intervals4)); // Returns 3, which is incorrect. correct Output: 2
        /*
         * Why?
         * 
         * At time 5, the meeting [1,5] has already ended, so its room can be reused.
         * But your code replaced the previous end time with 6 (from [2,6]) and forgot
         * that another room became available.
         * 
         * Correct approach
         * 
         * To solve Meeting Rooms II, you need to know which room becomes free first.
         * The standard solutions are:
         * 
         * Min Heap (PriorityQueue) of end times — O(n log n) (most common interview
         * solution).
         * Two sorted arrays (starts and ends) with two pointers — O(n log n) and O(n)
         * extra space.
         * 
         * Tracking only a single currentInterval isn't sufficient because multiple
         * meetings can be active simultaneously, each ending at different times.
         */
    }
}
