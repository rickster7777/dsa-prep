var singleNonDuplicate = function (nums) {
    let low = 0;
    let high = nums.length - 1;

    while (low < high) {
        let mid = Math.floor(low + ((high - low) / 2));

        if ((nums[mid] !== nums[mid - 1]) && (nums[mid] !== nums[mid + 1])) {
            return nums[mid];
        }

        //check in left part of the array.
        low++
        high = mid - 1;
    }

    low = 0;
    high = nums.length - 1;
    while (low < high) {
        let mid = Math.floor(low + ((high - low) / 2));

        if ((nums[mid] !== nums[mid - 1]) && (nums[mid] !== nums[mid + 1])) {
            return nums[mid];
        }

        //check in right part of the array.
        high--;
        low = mid + 1;
    }
};

// const nums = [1, 1, 2, 3, 3, 4, 4, 8, 8];
// const nums = [3, 3, 7, 7, 10, 11, 11];
const nums = [1, 1, 2];
console.log(singleNonDuplicate(nums));