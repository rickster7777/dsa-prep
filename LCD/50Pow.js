// var myPow = function (x, n) {
//     let res = 1;

//     if (n > 0) {
//         for (let i = 0; i < n; i++) {
//             res *= x;
//         }
//         return res;
//     } else if (n === 0) {
//         return 1;
//     } else {
//         n = -(n)
//         for (let i = 0; i < n; i++) {
//             res *= x;
//         }
//         res = 1 / 4
//         return res;
//     }

// };

// var myPow = function (x, n) {
//     let res = 1;

// };
// const x = 2.00000;
// const n = -2;

// console.log(myPow(x, n));


const myPow = (x, n) => {
    // Base case: n == 0, return 1
    if (n === 0) return 1.0;

    // If n is negative, calculate for positive n and take the reciprocal
    if (n < 0) {
        x = 1 / x;
        n = -n;
    }

    // Helper function to compute x^n using exponentiation by squaring
    const power = (x, n) => {
        if (n === 0) 
            return 1;
        console.log(x, n/2);
        const half = power(x, Math.floor(n / 2)); // Recursively calculate x^(n//2)

        console.log(n % 2 === 0 ? half * half : half * half * x);
        return n % 2 === 0 ? half * half : half * half * x; // If n is even or odd
    };

    return power(x, n);
};


const x = 2.00000, n = 10;
console.log(myPow(x, n));
//Output: 1024.00000

// Input: x = 2.00000, n = -2
// Output: 0.25000
// Explanation: 2-2 = 1/22 = 1/4 = 0.25