// 1ms Beats 99.54%
// var productExceptSelf = function (nums) {
//     const n = nums.length;
//     const answer = new Array(n).fill(1);

//     // First pass: Calculate the product of elements to the left of each index
//     let leftProduct = 1;
//     for (let i = 0; i < n; i++) {
//         answer[i] = leftProduct;
//         leftProduct *= nums[i];
//     }

//     let rightProduct = 1;
//     for (let i = nums.length - 1; i >= 0; i--) {
//         answer[i] = answer[i] * rightProduct;
//         rightProduct *= nums[i];
//     }

//     return answer;
// };






//Instead of using left and right product languages this prefix and suffix lingo can also be used

var productExceptSelf = function(nums) {
    let n = nums.length;
    let answer = new Array(n).fill(1);

    // Step 1: Compute prefix product (left to right)
    let prefix = 1;
    for (let i = 0; i < n; i++) {
        answer[i] = prefix;  // Store product of elements before nums[i]
        prefix *= nums[i];   // Update prefix product
    }

    // Step 2: Compute suffix product (right to left) and multiply with prefix
    let suffix = 1;
    for (let i = n - 1; i >= 0; i--) {
        answer[i] *= suffix; // Multiply with suffix product
        suffix *= nums[i];   // Update suffix product
    }

    return answer;
};


const nums = [1, 2, 3, 4]
console.log(productExceptSelf(nums));
