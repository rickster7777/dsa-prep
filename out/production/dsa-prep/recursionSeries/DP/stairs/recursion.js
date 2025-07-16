/**
 * 
 * @param {*} cost 
 * @param {*} n 
 * @returns 
 * 
 * Recursion method
 * On leetcode it gave time limit exceeded
 */

const solve = (cost, n) => {
    // BASE CASE

    if (n === 0) {
        return cost[0];
    }
    if (n === 1) {
        return cost[1];
    }

    let ans = cost[n] + Math.min(solve(cost, n - 1), solve(cost, n - 2));
    return ans;
}

const cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1];
let n = cost.length;

let ans = Math.min(solve(cost, n - 1), solve(cost, n - 2));
console.log(ans)
// return ans;


