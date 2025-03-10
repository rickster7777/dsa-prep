function containsNearbyDuplicate(nums, k) {
    var window = new Set();
    for (var i = 0; i < nums.length; i++) {
        if (window.has(nums[i])) {
            return true;
        }
        window.add(nums[i]);
        if (window.size > k) {
            window["delete"](nums[i - k]);
        }
    }
    return false;
}
// Test cases
var testCases = [
    { nums: [1, 2, 3, 1], k: 3, expected: true },
    { nums: [1, 0, 1, 1], k: 1, expected: true },
    { nums: [1, 2, 3, 1, 2, 3], k: 2, expected: false }
];
testCases.forEach(function (_a, index) {
    var nums = _a.nums, k = _a.k, expected = _a.expected;
    var result = containsNearbyDuplicate(nums, k);
    console.log("Test Case " + (index + 1) + ": Expected " + expected + ", Got " + result);
});
