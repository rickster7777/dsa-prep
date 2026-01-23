package challenging;

import java.util.ArrayList;
import java.util.List;

public class subset {

    // Helper function to perform the backtracking
    private void solve(List<Integer> nums, List<Integer> output, int index, List<List<Integer>> ans) {
        // Base case: when index reaches the size of nums, add the output to the answer
        if (index >= nums.size()) {
            ans.add(new ArrayList<>(output)); // Create a new list to avoid reference issues
            return;
        }

        // Exclude the current element and move to the next
        solve(nums, output, index + 1, ans);

        // Include the current element and move to the next
        output.add(nums.get(index));
        solve(nums, output, index + 1, ans);

        // Backtrack: remove the last added element
        output.remove(output.size() - 1);
    }

    // Main function to generate all subsets
    public List<List<Integer>> subsets(List<Integer> nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        solve(nums, output, index, ans);
        return ans;
    }

    public static void main(String[] args) {
        // Create an instance of the subset class
        subset solution = new subset();

        // Create the input list
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);

        // Call the subsets method with the input list
        List<List<Integer>> result = solution.subsets(input);

        // Print the result
        System.out.println(result);
    }
}
