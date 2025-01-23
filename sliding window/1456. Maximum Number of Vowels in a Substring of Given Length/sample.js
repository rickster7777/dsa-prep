// Mys olution this gave TLE.

var maxVowels = function (s, k) {

    let str = '';

    for (let i = 0; i < k; i++) {
        str += s[i];
    }


    const isVowel = (char) => {
        return 'aeiouAEIOU'.includes(char);
    };


    let maxCount = 0;

    const countVowels = (str) => {
        let count = 0
        for (let v = 0; v < k; v++) {
            const check = isVowel(str[v])
            if (check) {
                count++
            }
        }



        if (count > maxCount) {
            maxCount = count;
        }

        return maxCount;
    };

    countVowels(str);
    for (let i = k; i < s.length; i++) {
        str += s[i];
        str = str.slice(1);
        const count = countVowels(str);
        if (count === k) {
            return k;
        }
    }

    return maxCount;
};

// Issues with my approach

/**
  and how to optimize the approach:

Issues:
Recomputing the vowel count for each window: The function countVowels is being called on every iteration of the loop, and within that, 
you're scanning the entire window of size k (s[v] loop) for each window shift. This leads to an 
𝑂(𝑘)
O(k) complexity for each window, resulting in an overall time complexity of 
𝑂(𝑛 × 𝑘)
O(n×k), which is inefficient and likely causes the TLE.

String concatenation and slicing: You're modifying the str string on every iteration by appending a new character and slicing it. 
While this works, it's inefficient in JavaScript because strings are immutable, so each modification creates a new string, which adds 
unnecessary overhead. You should be using an array for sliding window or directly updating the count of vowels as you slide the window.

Sliding Window Optimization:
You can use the sliding window technique by:

Maintaining a running count of vowels in the window.
Updating the count when the window slides: For each new character entering the window, add to the count if it's a vowel, and subtract 
from the count if the character that's leaving the window is a vowel.
This allows you to keep the operation in 
𝑂(𝑛)
O(n), where n is the length of the string.
 */

//GPT solution 

const isVowel = (char) => {
    return 'aeiouAEIOU'.includes(char);
};

const maxVowelSubstring = (s, k) => {
    let vowelCount = 0;

    // Initial window setup: count vowels in the first window of size k
    for (let i = 0; i < k; i++) {
        if (isVowel(s[i])) {
            vowelCount++;
        }
    }

    let maxVowels = vowelCount;

    // Sliding window: slide through the string starting from index k
    for (let i = k; i < s.length; i++) {
        // Remove the vowel count of the character leaving the window (s[i-k])
        if (isVowel(s[i - k])) {
            vowelCount--;
        }

        // Add the vowel count of the new character entering the window (s[i])
        if (isVowel(s[i])) {
            vowelCount++;
        }

        // Update maxVowels if the current window has more vowels
        maxVowels = Math.max(maxVowels, vowelCount);

        // Early exit if the maxVowel count equals k (optimal condition found)
        if (maxVowels === k) {
            return k;
        }
    }

    return maxVowels;
};

const s = "abciiidef", k = 3;
console.log(maxVowels(s, k));