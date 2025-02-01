// var findDuplicate = function (nums) {
//     nums.sort((a, b) => a - b);

//     for (let i = 0; i < nums.length; i++) {
//         if (i > 0 && nums[i] === nums[i - 1]) {
//             return nums[i];
//         }
//     }
// };


var findDuplicate = function (nums) {

    const len = nums.length
    const dup = new Array(len + 1).fill(0);

    for (let i = 0; i < nums.length; i++) {
        dup[nums[i]]++;
        if (dup[nums[i]] > 1) {
            return nums[i];
        }
    }
};

const nums = [3, 3, 3, 3, 3];
console.log(findDuplicate(nums)); 

// my above approach was giving better results than this.
var findDuplicate = function(nums) {
    // Step 1: Initialize the tortoise and hare
    let tortoise = nums[0];
    let hare = nums[0];

    // Step 2: Find the intersection point (cycle detection)
    do {
        tortoise = nums[tortoise];    // Move tortoise by 1 step
        hare = nums[nums[hare]];      // Move hare by 2 steps
    } while (tortoise !== hare);      // Continue until they meet

    // Step 3: Find the entrance to the cycle (the duplicate number)
    tortoise = nums[0];               // Start tortoise at the beginning
    while (tortoise !== hare) {       // Move both pointers 1 step at a time
        tortoise = nums[tortoise];
        hare = nums[hare];
    }

    // Step 4: Return the duplicate number
    return hare;
};

// Example usage:
console.log(findDuplicate([1, 3, 4, 2, 2])); // Output: 2
console.log(findDuplicate([3, 1, 3, 4, 2])); // Output: 3
console.log(findDuplicate([3, 3, 3, 3, 3])); // Output: 3
