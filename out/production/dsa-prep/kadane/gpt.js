var maxSubArray = function (nums) {
    let currentSum = 0;
    let maxSum = nums[0]; // Initialize to the first element

    for (let i = 0; i < nums.length; i++) {
        //STEP 1
        currentSum += nums[i]; // Add current element to the sum

        //STEP 2
        maxSum = Math.max(maxSum, currentSum); // Update maxSum if currentSum is greater

        //STEP 3
        if (currentSum < 0) {
            currentSum = 0; // Reset current sum if it's negative
        }
    }

    return maxSum; // Return the maximum sum found
};


/**
✅ Core Idea
We go through the array, and at each step, we decide:
"Should I continue the previous subarray, or start a new one from this element?"


*/