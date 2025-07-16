// https://leetcode.com/problems/single-number/

// var singleNumber = function (nums) {

    let result = 0;

    for (const num of nums) {
        console.log(result);
        result ^= num;
        console.log(result);

    }

    return result
// };

/**
 0 ^ 2 = 2
 2 ^ 2 = 0
 0 ^ 1 = 1
 */


// const nums = [2, 2, 1];
// console.log(singleNumber(nums));

const singleNumber = (nums) => {
    const set = new Set();
    for (let i = 0; i < nums.length; i++) {
        if (set.has(nums[i])) {
            set.delete(nums[i]);  // Remove the number if it appears again (appears twice)
        } else {
            set.add(nums[i]);  // Add the number to the set (first occurrence)
        }
    }

    // The set will have only one element left, which is the single number
    return [...set][0];
};



const num = [4,1,2,1,2];
console.log(hashset(num));

const singleNumber = (nums) => {
    const sumOfNums = nums.reduce((acc, num) => acc + num, 0);
    const sumOfDistinct = new Set(nums).reduce((acc, num) => acc + num, 0);
    
    // Formula: 2 * sumOfDistinct - sumOfNums = single number
    return 2 * sumOfDistinct - sumOfNums;
};
