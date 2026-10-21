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

    // Approach in this is to put all the non zero elements at the start of the array.
    // Take action when there is a non zero element not the opposite
    for (let i = 0; i < nums.length; i++) {
        // If the current element is not zero
        if (nums[i] !== 0) {
            // Move the non-zero element to the 'pointer' index
            nums[pointer] = nums[i];

            // If current index is different from pointer,
            // set the current index to 0 (since its value was moved)
            if (i !== pointer) {
                nums[i] = 0;
            }

            // Move pointer to the next position
            pointer++;
        }
    }
    return nums;
};
/*
How to memorize this approach I've done this several times but still i forget it:

Your moveZeroes solution is not just for zeroes. It’s a type of “two-pointer / in-place rearrangement” problem.

Core idea:
“Keep a pointer for where the next valid element should go. Move elements forward, fill leftovers with default values.”

Step 2: Make a mental story
Think of it like a conveyor belt:
nums = [0, 1, 0, 3, 12]
pointer = 0

1. You walk through the array with i
2. If you see a non-zero, pick it up and place it at the pointer spot
3. Fill the spot you left with zero (if needed)
4. Move pointer forward


Step 3: Turn it into a mini “template”

Whenever you see problems like this, think:

1. Keep a pointer for the next “valid” spot (pointer = 0)
2. Loop through the array with index i
3. If nums[i] is valid:
    nums[pointer] = nums[i]
    If i != pointer, fix the old spot
    Move pointer++

4. Done!

This works for:
Move zeroes to end
Move all negative numbers to front
Partition arrays by even/odd
Sort 0s,1s,2s (Dutch national flag variant)
*/

// Cleaned Version:

var moveZeroess = function (nums) {
    let pointer = 0;

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== 0) {
            // Swap only if i != pointer to avoid unnecessary operations
            if (i !== pointer) {
                [nums[pointer], nums[i]] = [nums[i], nums[pointer]];
            }
            pointer++;
        }
    }

    return nums;
};

var frontZeroes = function (nums) {
    let start = 0;
    let end = nums.length - 1;

    while (start < end) {
        if (nums[start] !== 0 && nums[end] === 0) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        } else if (nums[start] === 0) {
            start++;
        } else {
            end--;
        }
    }
    return nums;
};


// 🔄 Modified Version: Move Zeros to the Left
// This version keeps non-zero elements at the end and pushes all zeroes to the start of the array, preserving the order of non-zero elements as well.


var moveZeroesToLeft = function (nums) {
    let pointer = nums.length - 1;

    // Traverse the array from right to left
    for (let i = nums.length - 1; i >= 0; i--) {
        if (nums[i] !== 0) {
            nums[pointer] = nums[i];
            if (i !== pointer) {
                nums[i] = 0;
            }
            pointer--;
        }
    }

    // Fill remaining positions on the left with 0s
    // for (let i = 0; i <= pointer; i++) {
    //     nums[i] = 0;
    // }

    return nums;
};
nums = [0, 1, 0, 3, 12]
//console.log(moveZeroes(nums));
//console.log(moveZeroes(nums));
console.log(moveZeroesToLeft(nums));