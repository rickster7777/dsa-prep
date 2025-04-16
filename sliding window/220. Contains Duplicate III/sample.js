// var containsNearbyAlmostDuplicate = function (nums, indexDiff, valueDiff) {
//     const arr = [];
//     for (let i = 0; i < nums.length; i++) {

//         arr.push(nums[i]);
//         if (arr.length > 1) {
//             let j = 0;
//             while (j < arr.length) {
//                 if (Math.abs(arr[j] - nums[i+1]) <= valueDiff) {
//                     return true;
//                 }
//                 j++;
//             }
//         }
//         if (arr.length <= indexDiff) {
//             continue;
//         }
//         else {
//             arr.shift();
//         }
//     }

//     return false;
// };

// //const nums = [1, 2, 3, 1], indexDiff = 3, valueDiff = 0;

// const nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3

// console.log(containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));

//above my approach

var containsNearbyAlmostDuplicate = function (nums, indexDiff, valueDiff) {
    const window = new Set(); // Sliding window set to store elements

    for (let i = 0; i < nums.length; i++) {
        // Check if any number in the window is within valueDiff range
        for (let num of window) {
            if (Math.abs(num - nums[i]) <= valueDiff) {
                return true;
            }
        }

        // Add the current number to the window
        window.add(nums[i]);

        // Maintain window size within indexDiff
        if (window.size > indexDiff) {
            window.delete(nums[i - indexDiff]);
        }
    }
    return false;
};

// Test cases
console.log(containsNearbyAlmostDuplicate([1, 2, 3, 1], 3, 0)); // true
console.log(containsNearbyAlmostDuplicate([1, 5, 9, 1, 5, 9], 2, 3)); // false
