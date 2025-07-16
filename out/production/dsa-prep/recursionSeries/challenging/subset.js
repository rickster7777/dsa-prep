/**
 * Given an integer array, numbs of unique elements, return all possible subset (the power set ) 
 * the solution must not contain duplicate upsets. Return the solution in any order.
 */

/**
 * Approach 1:
 * Backtracking: One way to approach this problem is to use backtracking. You will explore all 
 * possible subsets by including or excluding each element from the array.
Steps:
 * Sort the array (to help skip duplicates when iterating). 
 * Use a backtracking function to generate the subsets.
 * Whenever you encounter a duplicate element, you can skip it to avoid generating duplicate subsets.
 * Set for Uniqueness: You can use a set (or hash set) to store subsets to automatically handle duplicates, ensuring that each subset is unique.
 * 
 */


/**
Recursive Approach:
* Recursion Principle: Each element of the array can either be included in the current subset or excluded. You recursively explore 
    both possibilities: one where you include the element in the current subset and one where you don't. 

* To avoid duplicates, we can:
    Sort the array to group duplicates together.
    Skip over duplicate elements while generating subsets. 

 */

// The approach used in the code is backtracking with pruning based on the condition that skips duplicate elements in the array.
// Sorting the input array helps to group duplicates together, making it easier to skip them during recursion.

function findSubsets(nums) {
    const subsets = [[]]; // Initialize with an empty subset

    for (let i = 0; i < nums.length; i++) {
        const currentSubsetCount = subsets.length;
        for (let j = 0; j < currentSubsetCount; j++) {
            const newSubset = [...subsets[j], nums[i]];
            subsets.push(newSubset);
        }
    }

    return subsets;
}

// Example usage:
let nums = [1, 2, 3];
//const allSubsets = findSubsets(nums);
//console.log(allSubsets);



var subsetsWithDup = function (nums) {
    nums.sort((a, b) => a - b);  // Sort to handle duplicates easily
    const result = [];

    // Recursive function to generate subsets
    function generateSubset(index, currentSubset) {
        // Add the current subset to the result
        result.push([...currentSubset]);

        // Recurse over the remaining elements
        for (let i = index; i < nums.length; i++) {
            // Skip duplicates: if the current element is same as the previous, skip it
            if (i > index && nums[i] === nums[i - 1]) continue;
            // Include nums[i] in the subset and recurse for the next element
            generateSubset(i + 1, [...currentSubset, nums[i]]);
        }
    }

    // Start recursion from index 0 with an empty subset
    generateSubset(0, []);
    return result;
};

// Example usage:
//let nums = [1, 2, 2];
// let output = subsetsWithDup(nums);
// output.forEach(subset => console.log(subset));




// java code converted to js

// Helper function to perform the backtracking
function solve(nums, output, index, ans) {
    // Base case: when index reaches the size of nums, add the output to the answer
    if (index >= nums.length) {
        console.log("op ->", output);
        ans.push([...output]);  // Use spread to create a copy of the output array
        return;
    }

    // Exclude the current element and move to the next
    console.log("exc ->", output, index + 1, "ans->", ans);
    solve(nums, output, index + 1, ans);

    // Include the current element and move to the next
    console.log("op-push ->", nums[index]);
    output.push(nums[index]);
    console.log("inc ->", output, index + 1, "ans->", ans);
    solve(nums, output, index + 1, ans);

    // Backtrack: remove the last added element
    console.log("backtrack->", output);
    output.pop();
}

// Main function to generate all subsets
function subsets(nums) {
    let ans = [];
    let output = [];
    let index = 0;
    solve(nums, output, index, ans);
    return ans;
}

// Example usage:
const input = [1, 2, 3];
const result = subsets(input);
console.log(result);



// finding subsets using class in js

class Solution {
    // Helper function to perform the backtracking
    solve(nums, output, index, ans) {
        // Base case: when index reaches the size of nums, add the output to the answer
        if (index >= nums.length) {
            ans.push([...output]);  // Use spread to create a copy of the output array
            return;
        }

        // Exclude the current element and move to the next
        this.solve(nums, output, index + 1, ans);

        // Include the current element and move to the next
        output.push(nums[index]);
        this.solve(nums, output, index + 1, ans);

        // Backtrack: remove the last added element
        output.pop();
    }

    // Main function to generate all subsets
    subsets(nums) {
        let ans = [];
        let output = [];
        let index = 0;
        this.solve(nums, output, index, ans);
        return ans;
    }
}

// Example usage:
const solution = new Solution();
// const input = [1, 2, 3];
// const result = solution.subsets(input);
// console.log(result);
