/**
 * @param {string} s
 * @return {string}
 */
// var reverseWords = function (s) {
//     s = s.split(" ");

//     for (let i = 0; i < s.length; i++) {
//         let word = s[i];
//         let start = 0
//         let end = word.length - 1;
//         let temp = '';

//         while (start < end) {
//            temp = word[start];
//             word[start] = word[end];
//             word[end] = temp;
//             start++;
//             end--;
//         }
//         s[i] = word;
//     }

//     return s.join(" ");
// };

// let s = "Let's take LeetCode contest";
// console.log(reverseWords(s));

// ❌ Problem:
// In JavaScript, strings are immutable. That means you cannot modify individual characters in a string like you would in an array.

// So this line:

// word[start] = word[end]; // ❌ does nothing — strings are immutable
// doesn’t actually change the string word.

// ✅ Fix:
// Convert the word into a character array (using .split('')), do the reversal, and then join it back.

// ✅ Correct Version:

var reverseWords = function (s) {
    s = s.split(" "); // split into words

    for (let i = 0; i < s.length; i++) {
        let wordArr = s[i].split(""); // convert word to char array

        // Two-pointer reversal
        let start = 0;
        let end = wordArr.length - 1;
        while (start < end) {
            let temp = wordArr[start];
            wordArr[start] = wordArr[end];
            wordArr[end] = temp;
            start++;
            end--;
        }

        s[i] = wordArr.join(""); // convert back to string
    }

    return s.join(" ");
};

let s = "Let's take LeetCode contest";
console.log(reverseWords(s)); // Output: