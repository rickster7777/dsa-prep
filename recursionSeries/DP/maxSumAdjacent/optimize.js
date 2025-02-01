const maxSumNonAdjacent = (nums) => {
    const n = nums.length;

    // Base cases
    if (n === 0) return 0;        // No elements in the array
    if (n === 1) return nums[0];   // Only one element
    if (n === 2) return Math.max(nums[0], nums[1]); // Two elements

    // Initialize the dp array
    let prev2 = nums[0];   // dp[i-2]
    let prev1 = Math.max(nums[0], nums[1]);   // dp[i-1]

    // Iterate over the array starting from index 2
    for (let i = 2; i < n; i++) {
        let current = Math.max(prev1, nums[i] + prev2);
        prev2 = prev1;  // Update prev2 for the next iteration
        prev1 = current;  // Update prev1 for the next iteration
    }

    // The result is stored in prev1 (dp[n-1])
    return prev1;
};

// Example usage
const nums = [3, 2, 5, 10, 7];
console.log(maxSumNonAdjacent(nums)); // Output: 15 (because 3 + 10 + 7 = 15)
