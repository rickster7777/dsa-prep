// My solution
// 10 Jan 2025

// var pivotIndex = function (nums) {
//     let start = 0;
//     let last = nums.length - 1;
//     let left_sum = nums[start];
//     let right_sum = nums[last];

//     while (start < last) {

//         if (left_sum === right_sum) {
//             return start++;
//         } else if (left_sum < right_sum) {
//             left_sum += nums[start];
//             start++;
//         } else {
//             right_sum += nums[last];
//             last--;
//         }
//     }

//     return -1;
// };





//Gpt solution

/**
 * @param {number[]} nums
 * @return {number}
 */
var pivotIndex = function (nums) {
    let totalSum = 0;
    let leftSum = 0;

    // Step 1: Calculate the total sum of the array
    for (let num of nums) {
        totalSum += num;
    }

    // Step 2: Iterate through the array and find the pivot index
    for (let i = 0; i < nums.length; i++) {
        // Calculate the right sum as totalSum - leftSum - nums[i]
        if (leftSum === totalSum - leftSum - nums[i]) {
            return i;
        }

        // Update the left sum by adding the current number
        leftSum += nums[i];
    }

    // If no pivot index is found, return -1
    return -1;
};

const nums = [1, 7, 3, 6, 5, 6];
console.log(pivotIndex(nums));