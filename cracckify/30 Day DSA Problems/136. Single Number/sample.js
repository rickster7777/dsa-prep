var singleNumber = function (nums) {

    let result = 0;

    for (const num of nums) {
        result ^= num;
    }

    return result
};



/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function (nums) {
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