package SummaryOfRanges228;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums.length == 0)
            return result;

        int start = nums[0];

        for (int i = 1; i <= nums.length; i++) {
            // If at the end or the sequence breaks
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                // If the start is equal to the last number, add just the number
                if (start == nums[i - 1]) {
                    result.add(Integer.toString(start));
                } else {
                    // Otherwise, add the range in the format "start->end"
                    result.add(start + "->" + nums[i - 1]);
                }

                // Using ternary instead of above 
                //result.add(start == nums[i - 1] ? Integer.toString(start) : start + "->" + nums[i - 1]);

                // Update start to the next number if there’s another element
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();
        System.out.println(sr.summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 })); // ["0->2", "4->5", "7"]
        System.out.println(sr.summaryRanges(new int[] { 0, 2, 3, 4, 6, 8, 9 })); // ["0", "2->4", "6", "8->9"]
        System.out.println(sr.summaryRanges(new int[] {})); // []
    }
}
