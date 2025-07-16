var threeSum = function (nums) {
    const result = [];

    // Sort the array
    nums.sort((a, b) => a - b);

    // Loop through the array
    for (let i = 0; i < nums.length; i++) {
        // Skip the same element to avoid duplicates for `i`
        if (i > 0 && nums[i] === nums[i - 1]) {
            continue;
        }

        // ✅ Early termination: if current number is > 0, no triplet can sum to 0
        if (nums[i] > 0) break;

        // Initialize two pointers
        let left = i + 1;
        let right = nums.length - 1;

        // Two-pointer technique
        while (left < right) {
            const sum = nums[i] + nums[left] + nums[right];

            if (sum === 0) {
                // Found a valid triplet, add it to result
                result.push([nums[i], nums[left], nums[right]]);

                // Skip duplicates for `left`
                while (left < right && nums[left] === nums[left + 1]) {
                    left++;
                }

                // Skip duplicates for `right`
                while (left < right && nums[right] === nums[right - 1]) {
                    right--;
                }

                // Move both pointers after finding a triplet
                left++;
                right--;
            } else if (sum < 0) {
                left++; // Need a larger sum, so move `left` to the right
            } else {
                right--; // Need a smaller sum, so move `right` to the left
            }
        }
    }

    return result;
};