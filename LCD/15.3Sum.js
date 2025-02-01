var threeSum = function (nums) {
    const ans = [];

    for (let i = 0; i < nums.length; i++) {
        let a = nums[i];
        for (let j = i + 1; j < nums.length; j++) {
            let b = nums[j];
            for (let k = j + 1; k < nums.length; k++) {
                c = nums[k];

                if ((a + b + c === 0) && (i != j) && (i != k) && (j != k)) {
                    // To ensure distinct triplets are added here that logic is to be included going to gpt for that
                    ans.push([a, b, c]);
                }
            }
        }

    }

    return ans;
};

const nums = [-1, 0, 1, 2, -1, -4];
console.log(threeSum(nums));


/**
To ensure that you're only adding distinct triplets to the result array, you need to avoid adding duplicate triplets. One way to achieve 
this is to sort the triplets before adding them to the result and then check if the same triplet already exists in the result array.

Key Changes:
Sorting the input array: Sorting the array makes it easier to identify and avoid duplicates.
Skipping duplicates for the first number (i): If the current number is the same as the previous one, we skip it to avoid repeating the same triplet.

Two-pointer approach: After fixing the first element (i), we use two pointers (left and right) to find pairs that sum up to the target value (which is 0 in this case).

Skipping duplicates for left and right: When a triplet is found, we skip over any duplicate values of left and right to ensure each triplet is distinct.

This solution will run in O(n²) time complexity due to the nested loops and two-pointer technique. Sorting the array takes O(n log n), which is the most 
expensive operation. This ensures distinct triplets in an efficient manner.
 */



var threeSum = function (nums) {
    const ans = [];
    
    // Sort the array to help with duplicate checks
    nums.sort((a, b) => a - b);
    
    for (let i = 0; i < nums.length; i++) {
        // Skip the same element to avoid duplicates for `a`
        if (i > 0 && nums[i] === nums[i - 1]) {
            continue;
        }
        
        let left = i + 1;
        let right = nums.length - 1;
        
        while (left < right) {
            let sum = nums[i] + nums[left] + nums[right];
            
            if (sum === 0) {
                // Add the triplet to the answer
                ans.push([nums[i], nums[left], nums[right]]);
                
                // Skip duplicates for `left`
                while (left < right && nums[left] === nums[left + 1]) {
                    left++;
                }
                
                // Skip duplicates for `right`
                while (left < right && nums[right] === nums[right - 1]) {
                    right--;
                }
                
                // Move both pointers after processing
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
    
    return ans;
};


// most efficient

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
