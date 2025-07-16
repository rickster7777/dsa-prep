var findPeakElement = function (nums) {
    const arr = nums;
    arr.sort((a, b) => b - a);


    let start = 0, end = arr.length - 1;

    for (let i = 0; i < arr.length; i++) {
        // Iterate while start not meets end
        while (start <= end) {

            // Find the mid index
            let mid = Math.floor((start + end) / 2);

            if (nums[mid] === arr[i] && nums[mid - 1] < arr[i] && nums[mid + 1] > arr[i]) return mid;

            else if (nums[mid] < arr[i])
                start = mid + 1;
            else
                end = mid - 1;
        }
    }


};



//correct GPT solution
var findPeakElement = function (nums) {
    let start = 0, end = nums.length - 1;

    while (start < end) {
        let mid = Math.floor((start + end) / 2);

        // If the element at mid is less than the element on the right, the peak must be to the right.
        if (nums[mid] < nums[mid + 1]) {
            start = mid + 1;
        } else {
            // If the element at mid is greater than or equal to the element on the right, the peak is to the left or at mid.
            end = mid;
        }
    }

    // When start equals end, we have found a peak.
    return start;
};

// Test the function with examples
console.log(findPeakElement([1, 2, 3, 1])); // Output: 2 (Index of peak 3)
console.log(findPeakElement([1, 2, 1, 3, 5, 6, 4])); // Output: 5 (Index of peak 6)


nums = [1, 2, 3, 1];
console.log(findPeakElement(nums));