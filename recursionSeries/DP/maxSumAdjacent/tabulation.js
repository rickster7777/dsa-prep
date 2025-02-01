const tabulation = (nums) => {
    const n = nums.length;
    if (n === 0) return 0;  // Edge case if the input is an empty array
    if (n === 1) return nums[0];  // Edge case if there's only one element

    let dp = new Array(n);

    // Initialize the dp array
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);  // The second element should be the maximum of nums[0] and nums[1]

    // Start the loop from the 2nd index (i = 2)
    for (let i = 2; i < n; i++) {
        // Either include the current element or exclude it
        let incl = dp[i - 2] + nums[i];  // Include the current element
        let excl = dp[i - 1];            // Exclude the current element

        // Store the maximum of both choices
        dp[i] = Math.max(incl, excl);
    }

    // Return the last element in the dp array which holds the result
    return dp[n - 1];
}

const nums = [2, 1, 1, 2];

// Call the tabulation function to compute the result
const ans = tabulation(nums);  

console.log(ans);  // Output the result
