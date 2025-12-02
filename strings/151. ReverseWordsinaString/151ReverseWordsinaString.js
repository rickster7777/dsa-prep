//20 december 2024

var reverseWords = function (s) {
    s = s.trim().split(" ");
    let rev = "";

    for (let i = s.length - 1; i >= 0; i--) {
        if (s[i] !== '') {
            rev += s[i] + " "
        }
    }
    return rev;
};

// var reverseWords = function(s) {
//     // Step 1: Trim the string to remove leading and trailing spaces
//     s = s.trim();

//     // Step 2: Split the string into words
//     let words = s.split(/\s+/);  // This handles multiple spaces as well

//     // Step 3: Reverse the order of words
//     let reversedWords = words.reverse();

//     // Step 4: Join the reversed words with a single space between them
//     return reversedWords.join(" ");
// };

let s = "a good   example";
console.log(reverseWords(s));  // Output: "example good a"