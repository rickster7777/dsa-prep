let output = "";
let ans = [];
let mapping = [
    "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
];

var letterCombinations = function (digits) {
    if (digits.length === 0) {
        return []; // Return an empty array if there are no digits
    }
    
    // Recursive backtracking function
    const backtrack = (index) => {
        // Base case: If we have processed all digits, add the current output to results
        if (index === digits.length) {
            ans.push(output);
            return;
        }

        // Get the characters mapped for the current digit
        let mapped = mapping[Number(digits[index])];

        // Iterate over each character mapped for the current digit
        for (const char of mapped) {
            output += char;  // Add the character to the output
            backtrack(index + 1);  // Recurse for the next digit
            output = output.slice(0, -1);  // Backtrack by removing the last character
        }
    };

    backtrack(0);  // Start recursion with the first digit
    return ans;
};

// Test case: digits = "2"
console.log(letterCombinations("2"));  // Expected output: ["a", "b", "c"]
