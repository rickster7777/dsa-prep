package disappearednumbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dnumbers {

    public List<Integer> findDisappearedNumbers(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Dnumbers solution = new Dnumbers();

        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution.findDisappearedNumbers(nums1)); // Output: [5, 6]

        int[] nums2 = {1, 1};
        System.out.println(solution.findDisappearedNumbers(nums2)); // Output: [2]
    }
}




