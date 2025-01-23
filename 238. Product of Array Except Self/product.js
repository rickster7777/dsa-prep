// 1ms Beats 99.54%
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




const nums = [1, 2, 3, 4]
console.log(productExceptSelf(nums));

// 4 ms Beats 88.18%

var productExceptSelf = function(nums) {
    const n = nums.length;
    const answer = new Array(n);
    
    // Step 1: Compute left product for each element
    answer[0] = 1; 
    for (let i = 1; i < n; i++) {
        answer[i] = answer[i - 1] * nums[i - 1];
    }

    // Step 2: Compute right product and update the answer array
    let rightProduct = 1; 
    for (let i = n - 1; i >= 0; i--) {
        answer[i] = answer[i] * rightProduct; 
        rightProduct *= nums[i];
    }

    return answer;
};