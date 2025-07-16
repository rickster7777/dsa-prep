const solve = (nums, n) => {
    // Base case: when n is less than 0, no elements to sum
    if (n < 0) {
        return 0;
    }

    // Base case: when n is 0, only one element to choose from
    if (n === 0) {
        return nums[0];
    }

    //starting from end of the array going from right to left
    
    // Recursive case: either include or exclude the current element
    let incl = solve(nums, n - 2) + nums[n];  // Include current element
    let excl = solve(nums, n - 1);            // Exclude current element

    // Return the maximum of both cases
    return Math.max(incl, excl);
}

const nums = [2, 1, 1, 2];
const n = nums.length;  // Get the length of the array
const ans = solve(nums, n - 1);  // Start the recursion from the last index
console.log(ans);  // Output the result
