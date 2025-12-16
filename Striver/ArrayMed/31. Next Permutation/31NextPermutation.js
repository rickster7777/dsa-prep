/*
 * Lexicographic Order

It is similar to dictionary order (e.g., 123 < 132 < 213 < 231 < 312 < 321).
Example: The next permutation of [1,2,3] is [1,3,2].
Step-by-Step Algorithm:

1️⃣ Find the first decreasing element from the right
Traverse the array backward and find the first element nums[i] where nums[i] < nums[i+1].
This means nums[i] is the first number that needs to be swapped to get a bigger number.
Example: [1,3,5,4,2], here 3 < 5, so i = 1.

2️⃣ Find the next larger number to swap
Again, traverse backward and find the smallest number larger than nums[i].
Swap them to get the next larger sequence.
Example: In [1,3,5,4,2], nums[i] = 3, and the smallest number greater than 3 is 4. Swap 3 and 4, making [1,4,5,3,2].

3️⃣ Reverse the right part
Since the right part is now in descending order, reverse it to get the smallest lexicographical order.
Example: [1,4,5,3,2] → [1,4,2,3,5].
 */

var nextPermutation = function (nums) {
    let first = -1;


    for (let i = nums.length - 2; i >= 0; i--) {
        if (nums[i] < nums[i + 1]) {
            first = i;  // Store the first decreasing element index
            break;      // No need to continue once found
        }
    }


    for (let i = nums.length - 1; i >= 0; i--) {
        if ((i < nums.length - 1) && (nums[i] > first)) {
            first = i;
        }
    }
};

const nums = [1, 2, 3];
console.log(nextPermutation(nums));