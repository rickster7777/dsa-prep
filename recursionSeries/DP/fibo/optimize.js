/**
Optimized approach
Instead of using arrays it can also be solved by using just two variables.
because to find next fibonacci number only last two values are required to stored.

 */
function fibonacciBottomUp(n) {
    if (n <= 1) return n;

    //let fib = [0, 1];

    let prev1 = 1;
    let prev2 = 0;
    let curr
    // Iteratively compute the Fibonacci sequence from 2 to n
    for (let i = 2; i <= n; i++) {
        curr = prev1 + prev2;
        prev2 = prev1;
        prev1 = curr
        // fib[i] = fib[i - 1] + fib[i - 2];
    }


    return curr;
}

// Example usage:
const n = 4;
console.log(fibonacciBottomUp(n)); // Output: 55


/**
 Both approaches have a time complexity of O(n), but the space complexity differs:

Top-Down: O(n) due to the recursion stack and memoization storage.
Bottom-Up: O(n) because of the array used to store results.
 */