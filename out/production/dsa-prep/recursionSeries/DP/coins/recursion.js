/**
 * Time limit exceeded solution on leetcode
 * 
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up 
by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
 */

const minElementsToSumRec = (coins, amount) => {
    if (amount === 0) {
        return 0;
    }

    // If amount is negative, it's an invalid case.
    if (amount < 0) {
        return Infinity; // Return a large number indicating this path is invalid
    }

    let minCount = Infinity;

    // Try each coin and recurse
    for (let i = 0; i < coins.length; i++) {
        let count = minElementsToSumRec(coins, amount - coins[i]);
        
        if (count !== Infinity) {
            minCount = Math.min(minCount, count + 1); // +1 to account for the current coin
        }
    }

    if (minCount === 0) {
        minCount = -1;
    }
    // If minCount is still Infinity, return -1 as it's not possible to form the amount
    return minCount === Infinity ? -1 : minCount;
};

// Example usage:
const coins = [2];
const target = 3;
const result = minElementsToSumRec(coins, target);
console.log(result);  // Output: 2 (because 2 + 5 = 7)
