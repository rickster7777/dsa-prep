/**
 * @param {number[]} arr
 * @return {number[]}
 */
var pancakeSort = function(arr) {
    const result = [];

    // Start from the largest value and work down to 1
    for (let valueToPlace = arr.length; valueToPlace > 1; valueToPlace--) {
        // Find index of valueToPlace
        const index = arr.indexOf(valueToPlace);

        if (index === valueToPlace - 1) continue; // Already in the right place

        // Step 1: Bring the value to the front, if it's not already
        if (index !== 0) {
            flip(arr, index + 1);
            result.push(index + 1);
        }

        // Step 2: Flip to move it to its final position
        flip(arr, valueToPlace);
        result.push(valueToPlace);
    }

    return result;
};

// Helper to reverse the first k elements in-place
function flip(arr, k) {
    let left = 0;
    let right = k - 1;
    while (left < right) {
        [arr[left], arr[right]] = [arr[right], arr[left]];
        left++;
        right--;
    }
}
