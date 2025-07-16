// var minSubArrayLen = function (target, nums) {
//     let arrlength = nums.length;
//     let sum = 0;
//     let counter = 0;

//     for (let i = 0; i < nums.length; i++) {
//         sum += nums[i];

//         if (sum > target) {
//             //while (sum >= target) {
//                 sum -= nums[counter];
//                 counter++;
//             //}
//         }

//     }
//     if (sum < target) {
//         return 0;
//     }
//     return arrlength - (counter + 1);
// };


//correct approach
var minSubArrayLen = function (target, nums) {
    let left = 0;
    let sum = 0;
    let minLength = Infinity;

    for (let right = 0; right < nums.length; right++) {
        sum += nums[right];

        while (sum >= target) {
            minLength = Math.min(minLength, right - left + 1);
            sum -= nums[left];
            left++;
        }
    }

    return minLength === Infinity ? 0 : minLength;
};

const target = 7, nums = [2, 3, 1, 2, 4, 3];
console.log(minSubArrayLen(target, nums));