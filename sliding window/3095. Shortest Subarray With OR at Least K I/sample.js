// var minimumSubarrayLength = function (nums, k) {
//     let op = 0;
//     let windowSize = 0;
//     let finalSize = Infinity;


//     for (let i = 0; i < nums.length; i++) {
//         // willl it actually start like 0 | 1 | 2 | 3
//         op = op | nums[i];
//         windowSize++;

//         if (op >= k) {
//             // how to maintain the windows size here  ??
//             finalSize = Math.min(finalSize, windowSize);
//         }
//     }

//     return finalSize;
// };

// const nums = [1, 2, 3], k = 2;
// console.log(minimumSubarrayLength(nums, k));

//Correct GPT approach
var minimumSubarrayLength = function (nums, k) {
    let n = nums.length;
    let minLen = Infinity;

    for (let i = 0; i < n; i++) {
        let currentOr = 0;

        for (let j = i; j < n; j++) {
            currentOr |= nums[j];

            if (currentOr >= k) {
                minLen = Math.min(minLen, j - i + 1);
                break; // No need to check longer subarrays starting at i
            }
        }
    }

    return minLen === Infinity ? -1 : minLen;
};
