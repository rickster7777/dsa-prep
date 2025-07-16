const minElementsToSum = (coins, amount) => {
    // Create a memoization cache to store the results of subproblems
    let memo = new Array(amount + 1).fill(-1); // -1 means the result hasn't been computed yet

    // Base case: If amount is 0, return 0 because no coins are needed
    memo[0] = 0;

    // Recursive function to calculate the minimum number of coins for a given amount
    const solve = (amount) => {
        // If we've already computed this amount, return the cached result
        if (memo[amount] !== -1) {
            return memo[amount];
        }

        // Initialize the minimum count to Infinity (no solution found yet)
        let minCount = Infinity;

        // Try each coin and recursively calculate the result for the remaining amount
        for (let coin of coins) {
            if (coin <= amount) {
                let count = solve(amount - coin);
                if (count !== Infinity) {
                    minCount = Math.min(minCount, count + 1); // +1 to include the current coin
                }
            }
        }

        // Cache the result for the current amount
        memo[amount] = minCount === Infinity ? -1 : minCount;

        return memo[amount];
    };

    // Call the solve function to compute the result for the target amount
    return solve(amount);
};

// Example usage:
const coins = [1, 2, 5];
const target = 11;
console.log(minElementsToSum(coins, target)); // Output: 3 (because 5 + 5 + 1 = 11)
