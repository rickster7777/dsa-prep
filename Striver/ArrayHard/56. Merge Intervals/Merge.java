import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // Step 1: Sort the intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            // If the current interval overlaps with the next interval, merge them
            if (currentInterval[1] >= intervals[i][0]) {
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // No overlap, add the current interval to the merged list and move to the next
                merged.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        // Add the last interval
        merged.add(currentInterval);

        // Convert the list back to an array
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = { {1, 3}, {2, 6}, {8, 10}, {15, 18} }; // Output: [[1, 6], [8, 10], [15, 18]]
        int[][] mergedIntervals = merge(intervals);

        int[][] intervals1 = { {4, 7}, {1, 4} }; // Output: [[1, 7]]
        int[][] mergedIntervals1 = merge(intervals1);

        System.out.println("Merged Intervals:");
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
        System.out.println("Merged Intervals 1:");
        for (int[] interval : mergedIntervals1) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
