const fibo = (n) => {
    // Base case: If n is 0
    if (n === 0) {
        return 0;
    }

    if (n === 1 || n === 2) {
        return 1;
    }

    // Recursive case: F(n) = F(n-1) + F(n-2)

    return fibo(n - 1) + fibo(n - 2);


}

const ans = fibo(9);
console.log(ans);  // Output will be 8 (2^3)
