
import java.util.*;

/*
 my code in java 6 july 2025

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new Hashset<>();
        Set<Integer> set2 = new Hashset<>();

        set1.addAll(nums1);
        set2.addAll(nums2);

        a = set1.stream().filter(x -> !set2.has(x));
        b = set2.stream().filter(x -> !set1.has(x));

            return [a, b];
    }
}
 */
public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        // Copy to avoid modifying original sets
        Set<Integer> onlyIn1 = new HashSet<>(set1);
        Set<Integer> onlyIn2 = new HashSet<>(set2);

        onlyIn1.removeAll(set2); // Elements in nums1 but not in nums2
        onlyIn2.removeAll(set1); // Elements in nums2 but not in nums1

        List<List<Integer>> result = new ArrayList<>();
        // converting sets to lists:
        // these 2 ways are possible
        result.add(new ArrayList<>(onlyIn1));
        //result.add(Arrays.asList(onlyIn1.toArray(new Integer[0])));
        result.add(new ArrayList<>(onlyIn2));

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        List<List<Integer>> result = solution.findDifference(nums1, nums2);
        System.out.println(result); // Output: [[1, 3], [4, 6]]
    }
}

/*
 Usiong streams
 public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        // Elements only in nums1 (set1 - set2)
        List<Integer> onlyIn1 = set1.stream()
                .filter(x -> !set2.contains(x))
                .collect(Collectors.toList());

        // Elements only in nums2 (set2 - set1)
        List<Integer> onlyIn2 = set2.stream()
                .filter(x -> !set1.contains(x))
                .collect(Collectors.toList());

        return Arrays.asList(onlyIn1, onlyIn2);
    }
 */

/*
 Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums1. Therefore, answer[1] = [4,6].
Example 2:

Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
Output: [[3],[]]
Explanation:
For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
 */