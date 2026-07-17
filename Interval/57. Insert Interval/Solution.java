
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    /*
     * Idea
     * 
     * There are only three possibilities for every interval.
     * 
     * Case 1: Interval completely before new interval
     * [1,2] [5,7]
     * 
     * No overlap.
     * 
     * Add it to answer.
     * 
     * Case 2: Interval completely after new interval
     * [2,5]
     * [7,9]
     * 
     * Insert new interval first.
     * 
     * Then append remaining intervals.
     * 
     * Case 3: Overlap
     * [1,4]
     * [2,6]
     * 
     * Merge
     * start = min(start1,start2)
     * end = max(end1,end2)
     * 
     * Continue merging.
     * Algo
     * 1. Add all intervals ending before new interval.
     * 2. Merge all overlapping intervals.
     * 3. Add merged interval.
     * 4. Add remaining intervals.
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> merged = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1. Add all intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // 3. Add merged interval
        merged.add(newInterval);

        // 4. Add remaining intervals
        while (i < n) {
            merged.add(intervals[i]);
            i++;
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
    
    
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };
        // Output: [[1,5],[6,9]]

        int[][] result = sol.insert(intervals, newInterval);

        System.out.println("Resulting Intervals:");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

/*
56 — Merge Intervals
57 — Insert Interval
252 — Meeting Rooms (Premium)
253 — Meeting Rooms II (Premium)
435 — Non-overlapping Intervals
452 — Minimum Number of Arrows to Burst Balloons
986 — Interval List Intersections
*/