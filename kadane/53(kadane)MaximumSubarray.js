// kadane's algorithm
var maxSubArray = function (nums) {
    let sum = 0;
    let maxi = nums[0];

    for (let i = 0; i < nums.length; i++) {
        //STEP 1
        sum += nums[i];
        //STEP 2
        maxi = Math.max(maxi, sum);
        //STEP 3
        if (sum < 0) {
            sum = 0;
        }
    }

    return maxi;
};


const nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4];

console.log(maxSubArray(nums));