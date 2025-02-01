// const mapping = ["abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"];


// const phoneKeypad = (digits, output, index, ans, mapping) => {
//    // console.log("digits", digits);

//     if (index >= digits.length) {
//         ans.push(output);
//         return;
//     }

//     let mapped = mapping[Number(digits[index]) - 2]

//     for (const n of mapped) {
//         output.push(n);
//         phoneKeypad(digits, output, index + 1, ans, mapping);
//         output.pop();
//     }

//     // phoneKeypad(digits, index + 1, output, ans);


// }

const phoneKeypad = (digits, output, index, ans, mapping) => {
    // Base case: if we have processed all digits
    if (index >= digits.length) {
        ans.push(output);
        return;
    }

    // Get the corresponding string for the current digit
    
    // instead of this 
    //Number(digits[index])
    
    //This can also be done 
    //digits[index] - '0' 
    // Substracting '0' from numeric charac "2" gives it's equivalent integer value 2.

    let mapped = mapping[Number(digits[index])]; // Directly use the digit as index

    // Iterate through the characters mapped for the current digit
    for (const n of mapped) {
        output += n;  // Append the current character
        phoneKeypad(digits, output, index + 1, ans, mapping); // Recurse with updated output
        output = output.slice(0, -1);  // Remove the last character from output (backtracking)
    }
}

let digits = "89";
let output = "";
let ans = [];
let mapping = [
    "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
];

phoneKeypad(digits, output, 0, ans, mapping);
console.log(ans);  // This should now return the correct output
