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


/*
3364. Minimum Positive Sum Subarray 
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given an integer array nums and two integers l and r. Your task is to find the minimum sum of a subarray whose size is between l and r (inclusive) and whose sum is greater than 0.

Return the minimum sum of such a subarray. If no such subarray exists, return -1.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [3, -2, 1, 4], l = 2, r = 3
Output: 1
Explanation:
The subarrays of length between l = 2 and r = 3 where the sum is greater than 0 are:

[3, -2] with a sum of 1
[1, 4] with a sum of 5
[3, -2, 1] with a sum of 2
[-2, 1, 4] with a sum of 3
Out of these, the subarray [3, -2] has a sum of 1, which is the smallest positive sum. Hence, the answer is 1.

Example 2:

Input: nums = [-2, 2, -3, 1], l = 2, r = 3
Output: -1
Explanation:
There is no subarray of length between l and r that has a sum greater than 0. So, the answer is -1.

Example 3:

Input: nums = [1, 2, 3, 4], l = 2, r = 4
Output: 3
Explanation:
The subarray [1, 2] has a length of 2 and the minimum sum greater than 0. So, the answer is 3.


*/