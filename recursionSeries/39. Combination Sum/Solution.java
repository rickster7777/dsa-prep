/*
This problem is a classic extension of your “subsequence include/exclude” recursion pattern — but now with an extra condition (sum = target) and allowing 
repeated use of elements.
Let’s break it down and then write a clean, efficient Java solution.

🧠 Problem Understanding
You’re given:
An array of distinct positive integers candidates[].
A target integer target.
You must return all unique combinations of elements from candidates that sum exactly to target.
You can use each element unlimited times.

🔍 Key Observations
Unlimited reuse → you can pick the same element again,
so in recursion, the next call for "include" stays at the same index.
No duplicates → we can safely move to i + 1 when we exclude an element.
Sum constraint → when the running sum exceeds the target, we can prune that branch.

This makes it a backtracking problem with three key decisions:
Include the current number (stay at same index).
Exclude the current number (move to next index).
Stop exploring when the sum exceeds the target.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int index,
            List<Integer> current, List<List<Integer>> result) {
        // Base cases
        if (target == 0) {
            result.add(new ArrayList<>(current)); // found valid combination
            return;
        }
        if (target < 0 || index == candidates.length) {
            return; // invalid path
        }

        // Include the current element (can reuse it)
        current.add(candidates[index]);
        backtrack(candidates, target - candidates[index], index, current, result); // same index

        // Exclude the current element and move on
        current.remove(current.size() - 1);
        backtrack(candidates, target, index + 1, current, result);
    }
}
/*
 Start: index=0, target=7, []
 ├── include 2 → (index=0, target=5, [2])
 │     ├── include 2 → (index=0, target=3, [2,2])
 │     │     ├── include 2 → (index=0, target=1, [2,2,2]) ❌ (too small)
 │     │     └── exclude 2 → (index=1, target=3, [2,2])
 │     │           ├── include 3 → (index=1, target=0, [2,2,3]) ✅ add
 │     │           └── exclude 3 → ...
 │     ...
 │
 └── exclude 2 → (index=1, target=7, [])
       ├── include 3 → (index=1, target=4, [3])
       │     ├── include 3 → (index=1, target=1, [3,3]) ❌
       │     └── exclude 3 → (index=2, target=4, [3])
       └── exclude 3 → (index=2, target=7, [])
             ├── include 6 → ...
             ├── include 7 → (index=3, target=0, [7]) ✅ add

 */


/*
 If you prefer the for-loop backtracking style (more compact and readable):
 */

class SolutionCompact {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) continue; // pruning
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, path, result); // reuse same i
            path.remove(path.size() - 1);
        }
    }
}
