var getFinalState = function (nums, k, multiplier) {
    for (let i = 0; i < k; i++) {
        let smallest = Math.min(...nums);  // Spread operator to get the min value from the array
        let index = nums.indexOf(smallest);  // Find the index of the smallest element
        
        // Multiply the smallest element by the multiplier
        nums[index] *= multiplier;
    }

    return nums;
};

const nums = [2,1,3,5,6];
const k = 5;
const multiplier = 2;

console.log(getFinalState(nums, k, multiplier));


