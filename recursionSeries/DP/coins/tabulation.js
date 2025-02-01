// min no of coins needed to make denomination
// for eg coins = [1, 2, 5]
// no of coins needed to make 11 rs 
// answer is 3 coins =>> 5,5,1


/**
 * This solution got accepted in leetcode.
 *
*/


const minElementsToSum = (coins, amount) => {
    const n = coins.length;

    // Create dp array, initialized to Infinity, with dp[0] = 0.
    let dp = new Array(amount + 1).fill(Infinity);
    dp[0] = 0;  // It takes 0 elements to sum up to 0.

    // Loop through each coin in the array.
    for (let i = 0; i < n; i++) {
        // Update the dp array for all sums from coins[i] to amount.
        for (let j = coins[i]; j <= amount; j++) {
            dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
        }
        console.log(`dp after processing coin ${coins[i]}:`, dp);
    }

    // If dp[amount] is Infinity, it means we can't form the sum amount.
    return dp[amount] === Infinity ? -1 : dp[amount];
};

// Example usage:
const coins = [1, 2, 5];
const target = 11;
console.log(minElementsToSum(coins, target)); // Expected output: 3 (because 5 + 5 + 1 = 11)




/**
 Bottom-Up Tabulation:

In bottom-up tabulation, you start solving the problem from the base case and gradually build up to the final solution. 
You fill out a table (in this case, an array dp) iteratively.

Here, the dp array is filled in a sequential manner where you compute values for all possible sums from 0 to amount, starting from 0.
The two nested loops iterate over the available coins and amounts, updating the dp array. Each coin is used to update all relevant amounts.
This process fills out the entire dp table before the final answer (dp[amount]) is returned.


******************************************************************************************************************************

How the Provided Code is Bottom-Up Tabulation:
dp Array: The array dp is initialized with size amount + 1 and filled with Infinity to represent the minimum number of coins needed for each amount. The base case dp[0] = 0 is set because zero coins are needed to make the sum 0.
Iterative Calculation: The solution iterates over all coins and amounts, updating the dp array for each possible sum from 0 to amount based on the coins available.
The final solution is found in dp[amount], which gives the minimum number of coins needed to reach the target amount
 */