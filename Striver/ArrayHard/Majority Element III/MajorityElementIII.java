import java.util.ArrayList;
import java.util.List;

public class MajorityElementIII {
    public static List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        Integer candidate1 = null, candidate2 = null;

        // 1st pass: Find potential candidates
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) {
                count1++;
            } else if (candidate2 != null && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // 2nd pass: Verify candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
        }

        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        if (count1 > n / 3)
            result.add(candidate1);
        if (count2 > n / 3)
            result.add(candidate2);

        return result;
    }


    public static void main(String[] args) {

        int[] nums = {3, 2, 3};
        List<Integer> majorityElements = majorityElement(nums);

        int[] nums2 = {1, 1, 1, 3, 3, 2, 2, 2};
        List<Integer> majorityElements2 = majorityElement(nums2);

        System.out.println(majorityElements); // Output: [3]
        System.out.println(majorityElements2); // Output: [1, 2]
    }
}