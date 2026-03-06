import java.util.Arrays;
/*
Differences (concise)

Sorting key:
    eraseOverlapIntervals: sorts by start time (intervals[i][0]).
    eraseOverlapIntervals1: sorts by end time (intervals[i][1]).

Greedy decision:
    eraseOverlapIntervals1 (standard): after sorting by end, iterate and keep the interval with the earliest end; when an interval's start < prevEnd you remove the current interval (count++). This is the conventional and easiest-to-reason-about greedy.
    eraseOverlapIntervals: after sorting by start, when you detect an overlap you increment count and set prevEnd = Math.min(prevEnd, intervals[i][1]) — i.e., among overlapping intervals you keep the one with the earlier end. That local choice is equivalent to the standard greedy.

Readability and intent:
    Sorting-by-end makes the algorithm's intent explicit (pick intervals that finish earliest).
    Sorting-by-start needs the extra min step to enforce "keep earlier end" and is slightly less direct to read.

Complexity:
    Both: O(n log n) time (sorting) and O(1) extra space (ignoring input).

When to prefer which
    Prefer eraseOverlapIntervals1 (sort by end) for clarity and standardness; eraseOverlapIntervals is fine and equivalent, 
    but slightly less idiomatic.
*/
class Solution {
    // My approa
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;

        // Sort by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < prevEnd) {
                // Overlapping → remove the one with later ending time
                count++;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            } else {
                // Non-overlapping → keep it
                prevEnd = intervals[i][1];
            }
        }

        return count;

    }
    //Correct sol
    public int eraseOverlapIntervals1(int[][] intervals) {

        if (intervals.length <= 1) return 0;

        // Sort by ending time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < prevEnd) {
                // Overlapping → remove this interval
                count++;
            } else {
                // Non-overlapping → keep it
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};
        System.out.println(sol.eraseOverlapIntervals(intervals)); // Output: 1
        System.out.println(sol.eraseOverlapIntervals(new int[][]{{1,2}, {1,2}, {1,2}})); // Output: 2
    }
}