import java.util.ArrayList;
import java.util.List;

// class Solution {

//     List<List<Integer>> Ulist = new ArrayList<>();

//     public void subsequences(int[] nums, int index, List<Integer> list) {

//         if (index == nums.length) {
//             //Ulist.add(list);
//             Ulist.add(new ArrayList<>(list));
//             return;
//         }

//         //Include
//         list.add(nums[index]);
//         subsequences(nums, index + 1, list);

//         //Exclude
//         list.remove(list.size() - 1);
//         subsequences(nums, index + 1, list);
//     }

//     public List<List<Integer>> subsets(int[] nums) {
//         int index = 0;
//         List<Integer> list = new ArrayList<>();

//         subsequences(nums, index, list);

//         return Ulist;
//     }
// }


/*
🧩 Why that’s a problem

All recursive calls share the same list object (because Java passes object references).

Later, as recursion backtracks and list.remove(...) is called, the same underlying list gets modified.
By the time recursion is complete, all entries in Ulist point to that same now-empty list.

That’s why your output is:

[[], [], [], [], [], [], [], []]

This is to be used
Ulist.add(new ArrayList<>(list));

instead of this
Ulist.add(list);
*/

/*
 * Better Approach
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Include current element
        current.add(nums[index]);
        backtrack(nums, index + 1, current, result);

        // Exclude current element
        current.remove(current.size() - 1);
        backtrack(nums, index + 1, current, result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }
}
