var countBits = function (n) {
    let ans = new Array(n + 1);  // Create an array of length n + 1
    ans[0] = 0;  // Base case: number of 1s in 0 is 0

    for (let i = 1; i <= n; i++) {
        ans[i] = ans[i >> 1] + (i & 1);  // Dynamic programming step
    }

    return ans;
};



function countBits(n) {
    let ans = new Array(n + 1); // Array to store the count of 1s for each number from 0 to n
    ans[0] = 0; // Base case: the number of 1s in 0 is 0

    for (let i = 1; i <= n; i++) {
        ans[i] = ans[i & (i - 1)] + 1;
    }

    return ans;
}

n = 2
console.log(countBits(2));