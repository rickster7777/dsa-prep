// https://leetcode.com/problems/find-missing-and-repeated-values/submissions/1480952965/

/**
 * @param 76 ms Beats 15.22%
 * 
*/

// const findMissingAndRepeatedValues = (grid) => {
//     const nums = [];

//     // Flatten the 2D grid into a 1D array
//     for (let i = 0; i < grid.length; i++) {
//         nums.push(...grid[i]);
//     }

//     nums.sort((a, b) => a - b);  // Sort the array

//     const arr = [];
//     const n = nums.length;


//      // Check for repeated values
//      for (let i = 0; i < n; i++) {
//         if (nums.indexOf(nums[i]) !== i) {  // If current element is not at its first occurrence
//             arr.push(nums[i]);  // Repeated number
//             break;  // Once we find the repeated number, we break the loop.
//         }
//     }

//     // Check for missing and repeated values
//     for (let i = 1; i <= n; i++) {
//         // Check if i is missing from the array
//         if (!nums.includes(i)) {
//             arr.push(i);  // Missing number
//         }
//     }

//     return arr;
// };

//const grid = [[1, 3], [2, 2]];
//console.log(findMissingAndRepeatedValues(grid));  // Output: [4, 2]

/** 
 * @param This solution uses sets unlike above solution.
 * @param 6ms Beats 78.70%

 */


// const findMissingAndRepeatedValues = (grid) => {
//     const nums = [];

//     // Flatten the 2D grid into a 1D array
//     for (let i = 0; i < grid.length; i++) {
//         nums.push(...grid[i]);
//     }

//     const n = nums.length;
//     const seen = new Set();  // Set to track seen numbers
//     const arr = new Set();

//     // Check for repeated values
//     for (let i = 0; i < n; i++) {
//         if (seen.has(nums[i])) {
//             arr.add(nums[i]);  // If the number is already in the set, it's a duplicate
//             //break;  // Once we find the repeated number, break out of the loop
//         }
//         seen.add(nums[i]);
//     }

//     // Check for missing values
//     for (let i = 1; i <= n; i++) {
//         if (!seen.has(i)) {
//             arr.add(i);  // If the number is not in the set, it's missing
//         }
//     }

//     const myArr = [...arr];

//     return myArr;
// };

//const grid = [[9, 1, 7], [8, 9, 2], [3, 4, 6]];
//console.log(findMissingAndRepeatedValues(grid));  // Output: [4, 2]



//more optimized solution

/**
 * @param 6 ms Beats 78.70%

 * 
*/
const findmissing = (grid) => {
    let expSum, actualSum = 0;
    let a, b = 0;

    const n = grid.length;
    const seen = new Set();  // Set to track seen numbers
    const arr = [];

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            actualSum += grid[i][j];

            if (seen.has(grid[i][j])) {
                a = grid[i][j];
                arr.push(grid[i][j]);
            }
            seen.add(grid[i][j]);
        }
    }

    expSum = (n * n) * (n * n + 1) / 2;
    b = expSum + a - actualSum;

    arr.push(b);
    return arr;
};


// const grid = [[9, 1, 7], [8, 9, 2], [3, 4, 6]];
// console.log(findmissing(grid));



/**
 * Best solution
 * 1 ms Beats 99.57%

 */

/**
 * @param {number[][]} grid
 * @return {number[]}
 */
var findMissingAndRepeatedValues = function (grid) {
    const len = grid.length;
    const count = new Array(len * len + 1).fill(0);

    for (let i = 0; i < len; i++) {
        for (let j = 0; j < len; j++) {
            count[grid[i][j]]++;
        }
    }

    let repeated = -1;
    let missing = -1;
    const lenNums = len * len;
    for (let num = 1; num <= lenNums; num++) {
        if (count[num] === 2) repeated = num;
        if (count[num] === 0) missing = num;
        if (repeated != -1 && missing != -1) return [repeated, missing];
    }

    return [repeated, missing];
};


const grids = [[9, 1, 7], [8, 9, 2], [3, 4, 6]];
console.log(findMissingAndRepeatedValues(grids));

