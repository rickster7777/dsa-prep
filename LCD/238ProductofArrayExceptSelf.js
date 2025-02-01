// var productExceptSelf = function (nums) {
//     const len = nums.length;


//     for (let i = 0; i < nums.length; i++) {
//         let element = i + 1;
//         let mul = 1;
//         while (element < nums.length) {
//             mul = mul * nums[element];
//             nums[i] = mul;
//             element++;
//         }



//     }
//     return nums;
// };

// const nums = [1, 2, 3, 4];
// console.log(productExceptSelf(nums));





//what is prefix sum

// Function to compute prefix sum array
function computePrefixSum(arr) {
    let prefix_sum = new Array(arr.length);
    prefix_sum[0] = arr[0];

    // Compute the prefix sum
    for (let i = 1; i < arr.length; i++) {
        prefix_sum[i] = prefix_sum[i - 1] + arr[i];
    }

    return prefix_sum;
}

// Function to compute sum of elements from index l to r using prefix sum
function rangeSum(prefix_sum, l, r) {
    if (l === 0) {
        return prefix_sum[r];
    }
    return prefix_sum[r] - prefix_sum[l - 1];
}

// Example usage
let arr = [1, 2, 3, 4, 5];
let prefix_sum = computePrefixSum(arr);

console.log("Prefix Sum Array:", prefix_sum); // Output: [1, 3, 6, 10, 15]
console.log("Sum from index 1 to 3:", rangeSum(prefix_sum, 1, 3)); // Output: 9
console.log("Sum from index 2 to 4:", rangeSum(prefix_sum, 2, 4)); // Output: 12


//GPT 4 ms solution
var productExceptSelf = function(nums) {
    const n = nums.length;
    const answer = new Array(n);
    
    // Step 1: Compute left product for each element
    answer[0] = 1; // Initialize first element to 1 (no elements to the left of index 0)
    for (let i = 1; i < n; i++) {
        answer[i] = answer[i - 1] * nums[i - 1];
    }

    // Step 2: Compute right product and update the answer array
    let rightProduct = 1; // Start with 1 (no elements to the right of the last element)
    for (let i = n - 1; i >= 0; i--) {
        answer[i] = answer[i] * rightProduct; // Multiply with the right product
        rightProduct *= nums[i]; // Update right product for the next iteration
    }

    return answer;
};

// Example usage:
console.log(productExceptSelf([1, 2, 3, 4])); // Output: [24, 12, 8, 6]
console.log(productExceptSelf([-1, 1, 0, -3, 3])); // Output: [0, 0, 9, 0, 0]


// 1 ms solution
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function (nums) {
    const n = nums.length;
    const answer = new Array(n).fill(1);

    // First pass: Calculate the product of elements to the left of each index
    let leftProduct = 1;
    for (let i = 0; i < n; i++) {
        answer[i] = leftProduct;
        leftProduct *= nums[i];
    }

    let rightProduct = 1;
    for (let i = nums.length - 1; i >= 0; i--) {
        answer[i] = answer[i] * rightProduct;
        rightProduct *= nums[i];
    }
    
    return answer;
};




