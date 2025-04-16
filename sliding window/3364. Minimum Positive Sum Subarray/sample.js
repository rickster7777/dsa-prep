// var minimumSumSubarray = function (nums, l, r) {

//     let sum1 = 0;
//     for (let i = 0; i < l; i++) {
//         sum1 += nums[i];
//     }

//     let minSum = sum1;

//     let sum2 = 0;
//     for (let i = 0; i < r; i++) {
//         sum2 += nums[i];
//     }

//     for (let i = l; i < nums.length; i++) {
//         sum1 += nums[i];
//         sum1 -= nums[i - 2];
//         if (sum1 > 0) {
//             minSum = Math.min(minSum, sum1);
//         }
//     }

//     minSum = Math.min(minSum, sum2);

//     for (let i = r; i < nums.length; i++) {
//         sum2 += nums[i];
//         sum2 -= nums[i - 1];
//         if (sum2 > 0) {
//             minSum = Math.min(minSum, sum2);
//         }
//     }

//     if (minSum > 0) {
//         return minSum;
//     } else {
//         return -1;
//     }
// };

// I encountered this problem on 24 Nov 2024 and just solved this one almost at 9 : 29 .. Only 1 min before the contest ends and i almost get 4 wrong submissions in this.. 
// This is not easy definitely . This should be marked Medium. And could be a POTD in Feb 2025

// This was a tough problem

var minimumSumSubarray = function (nums, l, r) {
    let n = nums.length;
    let result = Infinity;

    for (let size = l; size <= r; size++) {
        let windowSum = 0;

        // Calculate initial window sum of current size
        for (let i = 0; i < size && i < n; i++) {
            windowSum += nums[i];
        }

        if (size <= n && windowSum > 0) {
            result = Math.min(result, windowSum);
        }

        // Slide the window
        for (let i = size; i < n; i++) {
            windowSum += nums[i] - nums[i - size];
            if (windowSum > 0) {
                result = Math.min(result, windowSum);
            }
        }
    }

    return result === Infinity ? -1 : result;
};


const nums = [3, -2, 1, 4], l = 2, r = 3;
console.log(minimumSumSubarray(nums, l, r));