/**
 * @param {number[]} nums
 * @return {string[]}
 */
var summaryRanges = function (nums) {
    let resultArray = [];

    if (nums.length === 0) return resultArray;

    let start = nums[0];

    for (let i = 1; i <= nums.length; i++) {
        // Check if we are at the last element or if the sequence breaks
        if (i === nums.length || nums[i] !== nums[i - 1] + 1) {
            if (start === nums[i - 1]) {
                resultArray.push(start.toString());  // Single number range
            } else {
                resultArray.push(`${start}->${nums[i - 1]}`);  // Range from start to current number
            }

            // If there's another element, set it as the new start
            if (i < nums.length) {
                start = nums[i];
            }
        }
    }

    return resultArray;
};


console.log(summaryRanges([0, 1, 2, 4, 5, 7])); 
// Output: ["0->2", "4->5", "7"]

console.log(summaryRanges([0, 2, 3, 4, 6, 8, 9])); 
// Output: ["0", "2->4", "6", "8->9"]

console.log(summaryRanges([])); 
// Output: []
