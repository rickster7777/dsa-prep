import java.util.HashMap;
import  java.util.Map;


public class Solution {
    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int target = k - num;
            if (map.containsKey(target) && map.get(target) > 0) {
                count++;
                map.put(target, map.get(target) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return count;
    }
}




/*
💡 Key Differences from Problem 560:

Aspect	        560. Subarray Sum Equals K	                 1679. Max Number of K-Sum Pairs
Task	        Count subarrays summing to k	                Count pairs summing to k
Technique	    Prefix sum + hashmap	                        Frequency map (hashmap of counts)
Elements reuse	Allowed in subarrays	                        Not allowed – use each element at most once
Order matters?	Yes (subarrays are ordered)	                    No – pairs are unordered (e.g. (2,3) = (3,2))

🏁 Conclusion:
Both use hashmaps for efficient lookup.

But 1679 does not use prefix sums.

It's more of a greedy + hashmap frequency based problem.

Let me know if you want to compare time complexities or dry-run any example together!
 */