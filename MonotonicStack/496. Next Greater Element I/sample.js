var nextGreaterElement = function(nums1, nums2) {
    const stack = [];
    const nextGreater = new Map(); // To store the next greater element for each number in nums2

    // Process nums2 in reverse to find next greater for each element
    for (let i = nums2.length - 1; i >= 0; i--) {
        let num = nums2[i];

        // Maintain decreasing stack: pop all elements smaller than or equal to current
        while (stack.length > 0 && stack[stack.length - 1] <= num) {
            stack.pop();
        }

        // If stack is not empty, top is the next greater element
        nextGreater.set(num, stack.length === 0 ? -1 : stack[stack.length - 1]);

        // Push current number onto stack
        stack.push(num);
    }

    // Build result for nums1 using the map
    return nums1.map(num => nextGreater.get(num));
};


// nums1 = [4, 1, 2]
// nums2 = [1, 3, 4, 2]

// nums1 is a subset of nums2.
// nextGreater:
// 1 → 3  
// 3 → 4  
// 4 → -1  
// 2 → -1  

// result = [nextGreater[4], nextGreater[1], nextGreater[2]] = [-1, 3, -1]

nextGreaterElement([4,1,2], [1,3,4,2]) // ➜ [-1, 3, -1]
nextGreaterElement([2,4], [1,2,3,4])   // ➜ [3, -1]
