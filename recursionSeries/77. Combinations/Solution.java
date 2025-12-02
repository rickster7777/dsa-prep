import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {

        int[] nums = new int[n];

        for (int i = 1; i < n + 1; i++) {
            nums[i - 1] = i;
        }

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result, k);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result, int k) {
        if (index == nums.length) {

            if (current.size() == k) {
                result.add(new ArrayList<>(current));
            }

            return;
        }

        // Include current element
        current.add(nums[index]);
        backtrack(nums, index + 1, current, result, k);

        // Exclude current element
        current.remove(current.size() - 1);
        backtrack(nums, index + 1, current, result, k);
    }

    // Simple main to test combine
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 1;
        int k = 1;
        System.out.println("combine(" + n + ", " + k + ") ->");
        List<List<Integer>> res = s.combine(n, k);
        for (List<Integer> comb : res) {
            System.out.println(comb);
        }
    }
}