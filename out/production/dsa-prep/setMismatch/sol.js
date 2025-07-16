//645. Set Mismatch



var findErrorNums = function (nums) {
    const set = new Set(nums);
    let n = nums.length;

    let total_sum = (n * (n + 1)) / 2;

    let sum = 0;
    for (const num of set) {
        sum += num;
    }

    let missing = total_sum - sum;
    return [missing - 1, missing];
};


nums = [1,2,2,4]
console.log(findErrorNums(nums));