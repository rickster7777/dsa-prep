import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        // Base case: if target becomes 0, we have found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // Explore further combinations
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (candidate > target) {
                // If the candidate exceeds the target, no point in exploring further
                continue;
            }

            currentCombination.add(candidate); // Add current candidate to the combination
            backtrack(candidates, target - candidate, i, currentCombination, result); // Recurse with the updated target
            currentCombination.remove(currentCombination.size() - 1); // Backtrack: remove the last added number
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        Solution solution = new Solution();
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        List<List<Integer>> result1 = solution.combinationSum(candidates1, target1);
        System.out.println("Test Case 1 Result: " + result1);

        // Test Case 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        List<List<Integer>> result2 = solution.combinationSum(candidates2, target2);
        System.out.println("Test Case 2 Result: " + result2);

        // Test Case 3
        int[] candidates3 = {2};
        int target3 = 1;
        List<List<Integer>> result3 = solution.combinationSum(candidates3, target3);
        System.out.println("Test Case 3 Result: " + result3);

        // Test Case 4 (edge case, no candidates)
        int[] candidates4 = {};
        int target4 = 5;
        List<List<Integer>> result4 = solution.combinationSum(candidates4, target4);
        System.out.println("Test Case 4 Result: " + result4);

        // Test Case 5 (target is zero)
        int[] candidates5 = {2, 3, 5};
        int target5 = 0;
        List<List<Integer>> result5 = solution.combinationSum(candidates5, target5);
        System.out.println("Test Case 5 Result: " + result5);
    }
}
