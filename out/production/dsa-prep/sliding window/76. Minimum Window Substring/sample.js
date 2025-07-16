var minWindow = function (s, t) {
    if (s.length < t.length) return "";

    // Step 1: Build a frequency map for characters in t
    const tFreq = new Map();
    for (let char of t) {
        tFreq.set(char, (tFreq.get(char) || 0) + 1);
    }

    // Variables to track sliding window and required conditions
    let left = 0;
    let have = 0;
    const need = tFreq.size;
    const window = new Map();

    // Variables to track the smallest window
    let minLen = Infinity;
    let resultStart = 0;

    // Step 2: Expand the window by moving the right pointer
    for (let right = 0; right < s.length; right++) {
        const c = s[right];
        window.set(c, (window.get(c) || 0) + 1);

        // If current character's count matches the required count, increment 'have'
        if (tFreq.has(c) && window.get(c) === tFreq.get(c)) {
            have++;
        }

        // Step 3: Try to shrink the window from the left while it satisfies the condition
        while (have === need) {
            // Update result if current window is smaller
            if ((right - left + 1) < minLen) {
                minLen = right - left + 1;
                resultStart = left;
            }

            // Shrink window from left
            const leftChar = s[left];
            window.set(leftChar, window.get(leftChar) - 1);

            if (tFreq.has(leftChar) && window.get(leftChar) < tFreq.get(leftChar)) {
                have--;
            }

            left++; // Move left pointer to the right
        }
    }

    // Step 4: Return result substring or empty string if no valid window was found
    return minLen === Infinity ? "" : s.slice(resultStart, resultStart + minLen);
};


// Example usage:
console.log(minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
console.log(minWindow("a", "a"));               // Output: "a"
console.log(minWindow("a", "aa"));              // Output: ""