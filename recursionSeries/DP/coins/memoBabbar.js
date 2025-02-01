/**
 * 
 * @param {*} coins 
 * @param {*} amount 
 * @param {*} dp 
 * @returns
 * 
 * 
 *  Time limit exceeded solution on leetcode 
 */

const solveMem = (coins, amount, dp) => {
    // BASE CASES
    if (amount === 0) {
        return 0;  // If the amount is 0, no coins are needed
    }

    if (amount < 0) {
        return Infinity;  // If the amount is negative, it's an invalid case
    }

    // If we have already computed the minimum number of coins for this amount
    if (dp[amount] !== -1) {
        return dp[amount];
    }

    let mini = Infinity;

    // Try each coin and recursively calculate the result for the remaining amount
    for (let i = 0; i < coins.length; i++) {
        let ans = solveMem(coins, amount - coins[i], dp);  // Subproblem with reduced amount
        if (ans !== Infinity) {
            mini = Math.min(mini, ans + 1);  // Add 1 to account for the current coin
        }
    }


    // Store the result in the dp array for the current amount
    dp[amount] = mini === Infinity ? -1 : mini;

    if (dp[amount] === 0) {
        dp[amount] = -1;
    }

    return dp[amount];
};

const minElementsToSum = (coins, amount) => {
    // Create a memoization cache, initialized to -1 (indicating unsolved subproblems)
    let dp = new Array(amount + 1).fill(-1);

    // Call the solveMem function to calculate the result for the given amount
    return solveMem(coins, amount, dp);
};

// Example usage:
const coins = [2];
const amount = 3;
console.log(minElementsToSum(coins, amount)); // Output: 3 (because 5 + 5 + 1 = 11)
