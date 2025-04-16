function containsNearbyDuplicate(nums: number[], k: number): boolean {
    let window = new Set<number>();

    for (let i = 0; i < nums.length; i++) {
        if (window.has(nums[i])) {
            return true;
        }

        window.add(nums[i]);

        if (window.size > k) {
            window.delete(nums[i - k]);
        }
    }

    return false;
}

// Test cases
const testCases = [
    { nums: [1, 2, 3, 1], k: 3, expected: true },
    { nums: [1, 0, 1, 1], k: 1, expected: true },
    { nums: [1, 2, 3, 1, 2, 3], k: 2, expected: false }
];

testCases.forEach(({ nums, k, expected }, index) => {
    const result = containsNearbyDuplicate(nums, k);
    console.log(`Test Case ${index + 1}: Expected ${expected}, Got ${result}`);
});
