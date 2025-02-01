const solve = (cost, n) => {

    //STEP 1
    let dp = new Array(n + 1);

    //STEP 2
    dp[0] = cost[0];
    dp[1] = cost[1];

    //STEP 3
    for (let i = 2; i <= n; i++) {
        dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
    }

    // Return the minimum cost to reach the last step (either from step n-1 or n-2)

    return dp[n];
}


const cost = [10, 15, 20];
let n = cost.length;

let ans = Math.min(solve(cost, n - 1), solve(cost, n - 2));
console.log(ans)