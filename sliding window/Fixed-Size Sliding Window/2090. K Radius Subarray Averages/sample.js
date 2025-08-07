/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
//My Approach
// var getAverages = function (nums, k) {
//     const avgs = new Array(k).fill(-1);

//     if (avgs.length <= k) {
//         return avgs;
//     }
//     let sum = 0;

//     let avgDen = 0;

//     for (let i = 0; i < 2 * k; i++) {
//         sum += nums[i];
//         avgDen++;
//     }
//     avgs[k] = sum / avgDen
//     for (let i = 2 * k + 1; i < nums.length; i++) {
//         sum += nums[i];
//         sum += nums[i] - nums[i - k];
//         avgs[i] = sum / avgDen;
//     }

//     return avgs;
// };

// GPT said
// I'd rate your current implementation of the solution around 3/10, and here's why:

var getAverages = function (nums, k) {
    const n = nums.length;
    const avgs = new Array(n).fill(-1);

    if (k === 0) return nums;
    if (2 * k + 1 > n) return avgs; // Not enough elements

    let windowSum = 0;
    const windowSize = 2 * k + 1;

    // Precompute the first window
    for (let i = 0; i < windowSize; i++) {
        windowSum += nums[i];
    }

    avgs[k] = Math.floor(windowSum / windowSize);

    for (let i = k + 1; i < n - k; i++) {
        windowSum = windowSum - nums[i - k - 1] + nums[i + k];
        avgs[i] = Math.floor(windowSum / windowSize);
    }

    return avgs;
};
