

function comb(n, k) {
    if (n < 0 || k < 0 || k > n) return 0;
    let res = 1;
    for (let i = 1; i <= k; i++) {
        res = res * (n - i + 1) / i;
    }
    return res;
}
var distributeCandies = function (n, limit) {
    let total = comb(n + 2, 2);

    let over1 = comb(n - (limit + 1) + 2, 2);
    let over2 = comb(n - 2 * (limit + 1) + 2, 2);
    let over3 = comb(n - 3 * (limit + 1) + 2, 2);

    let invalid = 3 * over1 - 3 * over2 + over3;

    return total - invalid;
};