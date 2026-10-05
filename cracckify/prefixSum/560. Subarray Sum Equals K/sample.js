/**
 * 
 * @param {*} nums 
 * @param {*} k 
Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2


✅ Correct Approach (Prefix Sum + HashMap):
Instead of maintaining just a running sum, the correct and efficient way is:

1. Keep a running prefix sum.
2. Use a HashMap to store the frequency of prefix sums.
3. At each step, check if prefixSum - k exists in the map. If yes, you found a subarray ending at current index with sum k
 */

var subarraySum = function (nums, k) {
    let sum = 0;           // Step 1: Running prefix sum
    let count = 0;         // Step 1: Number of subarrays found
    let map = new Map();   // Step 1: Map to store frequency of prefix sums
    map.set(0, 1);         // Step 2: Base case

    for (let i = 0; i < nums.length; i++) {
        sum += nums[i];    // Step 3a: Update running sum

        if (map.has(sum - k)) {         // Step 3b: Check for subarray sum
            count += map.get(sum - k);  // Increment count
        }

        map.set(sum, (map.get(sum) || 0) + 1); // Step 3c: Update map
    }

    return count; // Step 4: Return result
};
