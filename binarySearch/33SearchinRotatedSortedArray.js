var search = function (nums, target) {

    let low = 0;
    let high = nums.length - 1;
    let mid;

    while (high >= low) {
        mid = low + Math.floor((high - low) / 2);

        // If the element is present at the middle
        // itself
        if (nums[mid] == target)
            return mid;

        // If element is smaller than mid, then
        // it can only be present in left subnumsay
        if (nums[mid] > target)
            high = mid - 1;

        // Else the element can only be present
        // in right subnumsay
        else
            low = mid + 1;
    }
    return -1;
};

// const nums = [4, 5, 6, 7, 0, 1, 2], target = 0;
// console.log(search(nums, target));


//rotated sorted array approach

var search = function (nums, target) {
    let low = 0;
    let high = nums.length - 1;

    while (low <= high) {
        let mid = low + Math.floor((high - low) / 2);

        // If the element is found at mid
        if (nums[mid] === target) {
            return mid;
        }

        // Check if the left half is sorted
        if (nums[low] <= nums[mid]) {
            // Target is in the left half
            if (nums[low] <= target && target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // Else the right half must be sorted
        else {
            // Target is in the right half
            if (nums[mid] < target && target <= nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }

    return -1;
};

// Example usage:
const nums = [4, 5, 6, 7, 0, 1, 2];
const target = 0;
console.log(search(nums, target));  // Output: 4
