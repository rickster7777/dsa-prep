//287. Find the Duplicate Number

// var findDuplicate = function (nums) {
//     nums.sort((a, b) => a - b);

//     for (let i = 0; i < nums.length; i++) {
//         if (i > 0 && nums[i] === nums[i - 1]) {
//             return nums[i];
//         }
//     }
// };


// var findDuplicate = function (nums) {

//     const len = nums.length
//     const dup = new Array(len + 1).fill(0);

//     for (let i = 0; i < nums.length; i++) {
//         dup[nums[i]]++;
//         if (dup[nums[i]] > 1) {
//             return nums[i];
//         }
//     }
// };

// const nums = [3, 3, 3, 3, 3];
// console.log(findDuplicate(nums));

// // my above approach was giving better results than this.
var findDuplicate = function (nums) {
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


/**
 Why Use do-while Instead of while?
Ensures the pointers move at least once before checking for a cycle.

In Floyd’s Cycle Detection Algorithm (Tortoise and Hare), both slow and fast start at the same position (nums[0]).
If we use while (slow != fast), it would immediately break if slow and fast start at the same value.
But we need to move at least once to enter the cycle.
Ensures proper cycle detection.

The first move is required to start detecting a cycle.
do-while guarantees that we always move the pointers before checking slow == fast.
 */



/**
I'm getting the duplicate number after the step 2 only then why the step 3 is required ?

Great question!
In Step 2, we detect the meeting point of the two pointers, but this does not
necessarily give us the duplicate number. Step 3 is required to pinpoint the exact duplicate value.

Why Do We Need Step 3?
In Step 2, the slow and fast pointers meet somewhere in the cycle. However, that meeting point is not
necessarily the duplicate number—it's just somewhere inside the cycle.

To find the entrance to the cycle (which corresponds to the duplicate number), we reset slow and move
both pointers at the same pace until they meet again.



 */
//10 march 2024
// const findDuplicate = (nums) => {

//     const seen = new Set();

//     for (const num of nums) {
//         if (seen.has(num)) {
//             return num;
//         } else {
//             seen.add(num);
//         }
//     }
// };
// Example usage:
console.log(findDuplicate([1, 3, 4, 2, 2])); // Output: 2
console.log(findDuplicate([3, 1, 3, 4, 2])); // Output: 3
console.log(findDuplicate([3, 3, 3, 3, 3])); // Output: 3




/**
Alternative Approaches

Approach	                Time Complexity	        Space Complexity	    Modifies Array?
Sorting + Check Adjacent	  O(n log n)	           O(1)                        	✅ Yes
HashSet (Extra Memory)	      O(n)	                   O(n)	                        ❌ No
Floyd’s Cycle Detection (Best Approach)	O(n)	       O(1)	                        ❌ No

 */