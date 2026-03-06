/**
 Bottom-Up Approach (Tabulation):

In this approach, we iteratively calculate the Fibonacci numbers starting from 0 and 1, storing each result in an array.
The final Fibonacci number is then found at the nth index of the array.
 */
function fibonacciBottomUp(n) {
    if (n <= 1) return n;

    let fib = [0, 1];

    // Iteratively compute the Fibonacci sequence from 2 to n
    for (let i = 2; i <= n; i++) {
        fib[i] = fib[i - 1] + fib[i - 2];
    }

    return fib[n];
}

// Example usage:
const n = 10;
console.log(fibonacciBottomUp(n)); // Output: 55


/**
 Both approaches have a time complexity of O(n), but the space complexity differs:

Top-Down: O(n) due to the recursion stack and memoization storage.
Bottom-Up: O(n) because of the array used to store results.
 */