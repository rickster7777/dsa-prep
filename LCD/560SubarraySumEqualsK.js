var subarraySum = function (nums, k) {
    let sum = 0;
    let count = 0;

    for (let i = 0; i < nums.length; i++) {
        sum += nums[i];
        
        if (sum === k) {
            count++;
            sum = nums[i]
        } else if(sum > k){
            sum = 0;
        }
    }
    return count;

};

// const computePrefixSum = (nums) => {

//     const prefix_sum = new Array(nums.length).fill(0);

//     prefix_sum[0] = nums[0];

//     for (let i = 1; i < nums.length; i++) {
//         prefix_sum[i] = nums[i] + prefix_sum[i - 1];
//     }
//     return prefix_sum;
// };

const nums = [1, 1, 1], k = 2;
const nums1 = [1,2,3], k1 = 3;

//let prefix_sum = computePrefixSum(nums);
console.log(subarraySum(nums1, k1));