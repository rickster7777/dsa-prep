// This is the last and the most optimized approach out of all the 4 solutions of the problems


const solve = (cost, n) => {

    //STEP 1
    //let dp = new Array(n + 1);

    //STEP 2
    let prev2 = cost[0];
    let prev1 = cost[1];
    let curr

    //STEP 3
    for (let i = 2; i <= n; i++) {
        curr = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        prev2 =  prev1;
        prev1 = curr;    
    }

    // Return the minimum cost to reach the last step (either from step n-1 or n-2)
    return curr;
}


const cost = [10, 15, 20];
let n = cost.length;

let ans = Math.min(solve(cost, n - 1), solve(cost, n - 2));
console.log(ans)