const solve = (nums, n, dp) => {
    // Base case: when n is less than 0, no elements to sum
    if (n < 0) {
        return 0;
    }

    // Base case: when n is 0, only one element to choose from
    // if (n === 0) {
    //     return nums[0];
    // }

    //STEP 3: (IN MEMOIZATION) 
    if(dp[n] !== -1){
        return dp[n];
    }

    //starting from end of the array going from right to left
    // Recursive case: either include or exclude the current element
    let incl = solve(nums, n - 2, dp) + nums[n];  // Include current element
    let excl = solve(nums, n - 1, dp);            // Exclude current element

    //STEP 2: Store the results in the dp array.
    dp[n] = Math.max(incl, excl);
    // Return the maximum of both cases
    return dp[n];
}

const nums = [2, 1, 1, 2];
const n = nums.length;  // Get the length of the array
//STEP 1: Create a dp array
let dp = new Array(n+1).fill(-1);
const ans = solve(nums, n - 1, dp);  // Start the recursion from the last index

console.log(ans);  // Output the result
