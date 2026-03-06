/**
 Top-Down Approach (Memoization):

This method uses recursion and a memo object to store previously computed Fibonacci numbers.
If a number is already computed, it directly returns the result from memo.
This reduces redundant calculations and avoids the exponential time complexity of the naive recursive approach.
 */


function fibonacciTopDown(n, memo = {}) {
    // Base case: return n if it's 0 or 1
    if (n <= 1) return n;

    // Check if the value has already been computed
    if (n in memo) {
        return memo[n];
    }

    // Store the result in the memo table
    memo[n] = fibonacciTopDown(n - 1, memo) + fibonacciTopDown(n - 2, memo);

    return memo[n];
}

// Example usage:
const n = 10;
console.log(fibonacciTopDown(n)); // Output: 55
