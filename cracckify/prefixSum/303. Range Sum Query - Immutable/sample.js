/**
 * @param {number[]} nums
 */
var NumArray = function (nums) {
    // Store prefix sums
    this.prefix = new Array(nums.length + 1).fill(0);

    for (let i = 0; i < nums.length; i++) {
        this.prefix[i + 1] = this.prefix[i] + nums[i];
    }
};

/** 
 * @param {number} left 
 * @param {number} right
 * @return {number}
 */
NumArray.prototype.sumRange = function (left, right) {
    return this.prefix[right + 1] - this.prefix[left];
};



//✅ ES6 Version (JavaScript Class)
// class NumArray {
//     constructor(nums) {
//         this.prefix = new Array(nums.length + 1).fill(0);

//         for (let i = 0; i < nums.length; i++) {
//             this.prefix[i + 1] = this.prefix[i] + nums[i];
//         }
//     }

//     sumRange(left, right) {
//         return this.prefix[right + 1] - this.prefix[left];
//     }
// }

// Example usage:
const obj = new NumArray([-2, 0, 3, -5, 2, -1]);
console.log(obj.sumRange(0, 2)); // 1
console.log(obj.sumRange(2, 5)); // -1
console.log(obj.sumRange(0, 5)); // -3
