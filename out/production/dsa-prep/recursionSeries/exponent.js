// const exponent = (n) => {
//     if (n === 0) {
//         return 1;
//     }

//     let smallerProblem = 2 ** n - 1;
//     let biggerProblem = 2 * exponent(smallerProblem);
//     return biggerProblem;
// }

// const ans = exponent(3);
// console.log(ans);

const exponent = (n) => {
    // Base case: If n is 0, return 1 (2^0 = 1)
    if (n === 0) {
        return 1;
    }

    // Recursive case: 2^n = 2 * 2^(n-1)
    return 2 * exponent(n - 1);
}

const ans = exponent(5);
console.log(ans);  // Output will be 8 (2^3)
