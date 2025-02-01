const solve = (cost, n, dp) => {
    // BASE CASE
    if (n === 0) {
        return cost[0];
    }
    if (n === 1) {
        return cost[1];
    }
    
    // STEP 3
    if(dp[n] != -1){
        return dp[n];
    }
    // STEP 2
    dp[n] = cost[n] + Math.min(solve(cost, n - 1, dp), solve(cost, n - 2, dp));
    return dp[n];
}

const cost = [10, 15, 20];
let n = cost.length;

// STEP 1
const dp = new Array(n + 1).fill(-1);

let ans = Math.min(solve(cost, n - 1, dp), solve(cost, n - 2, dp));
console.log(ans)
