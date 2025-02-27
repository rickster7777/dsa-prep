// var moveZeroes = function (nums) {
//     let i = 0, zero = 0;

//     if (nums.length <= 1) {
//         return nums;
//     }
//     while (i < nums.length) {
//         if (nums[i] !== 0 & zero !==i) {
//             nums[zero] = nums[i];
//             nums[i] = 0;
//             i++;
//             //zero++;
//         } else if (nums[i] === 0) {
//             zero = i;
//             i++;
//         }

//     }
//     return nums;
// };


// const moveZeroes = (nums) => {
//     let i = 0;
//     let zero = 0;

//     while (i < nums.length) {
//         if (nums[i] === 0 && nums[zero] !== 0) {
//             nums[zero] = i;
//         }

//         if (nums[i] !== 0 && zero < i) {
//             nums[zero] = nums[i];
//             nums[i] = 0;
//         }

//         i++
//     }
//     return nums;
// }

/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function (nums) {
    let pointer = 0;
    if (nums.length <= 1) {
        return nums;
    }
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== 0) {
            nums[pointer] = nums[i];
            if (i !== pointer) {
                nums[i] = 0;
            }
            pointer++;
        }
    }
    return nums;
};
nums = [0, 1, 0, 3, 12]
console.log(moveZeroes(nums));