function intersection(nums1: number[], nums2: number[]): number[] {
    const numSet1 = new Set(nums1);

    const numSet2 = new Set(nums2);

    return Array.from(numSet1).filter(item => numSet2.has(item));
};


// const testCases = [
//     { nums: [1, 2, 3, 1], k: 3, expected: true },
//     { nums: [1, 0, 1, 1], k: 1, expected: true },
//     { nums: [1, 2, 3, 1, 2, 3], k: 2, expected: false }
// ];

// testCases.forEach(({ nums, k, expected }, index) => {
//     const result = containsNearbyDuplicate(nums, k);
//     console.log(`Test Case ${index + 1}: Expected ${expected}, Got ${result}`);
// });