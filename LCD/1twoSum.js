/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
    let myMap = new Map(); // To store value and its corresponding index
    
    for (let i = 0; i < nums.length; i++) {
        let complement = target - nums[i];  // Find the complement
        
        // If the complement is already in the map, we found the solution
        if (myMap.has(complement)) {
            return [myMap.get(complement), i];  // Return indices of the complement and current element
        }
        
        // Otherwise, store the current number with its index
        myMap.set(nums[i], i);
    }
    
    return [];  // In case there is no solution (although the problem guarantees one solution)
};

const nums = [2, 7, 11, 15], target = 9;
console.log(twoSum(nums, target));  // Output: [0, 1]