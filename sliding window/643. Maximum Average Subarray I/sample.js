// Naive solution
var findMaxAverage = function (nums, k) {
    let max = -Infinity; // Initialize max to a very low value

    for (let i = 0; i <= (nums.length - k); i++) { // Change to `<=` for correct range
        let sum = 0;
        for (let j = i; j < (i + k); j++) {
            sum += nums[j];
        }
        if ((sum / k) > max) {
            max = sum / k;
        }
    }

    return max;
};


// Using sliding window approach
const nums = [0, 1, 1, 3, 3], k = 4
console.log(findMaxAverage(nums, k));



var findMaxAverage = function (nums, k) {
    let sum = 0;
    // First, calculate the sum of the first window of size k
    for (let i = 0; i < k; i++) {
        sum += nums[i];
    }
    
    let max = sum;  // Initialize max with the first window's sum

    // Slide the window across the array
    for (let i = k; i < nums.length; i++) {
        sum += nums[i] - nums[i - k];  // Add the new element and remove the old one
        max = Math.max(max, sum);  // Update max if needed
    }

    return max / k;  // Return the average of the max sum window
};



