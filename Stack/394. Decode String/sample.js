var decodeString = function(s) {
    let stack = [];  // Stack to store previous strings and numbers
    let currentStr = '';  // To store the current decoded string
    let currentNum = 0;   // To accumulate the current number (k)
    
    for (let i = 0; i < s.length; i++) {
        let char = s[i];
        
        if (char >= '0' && char <= '9') {
            // Accumulate the current number (it may be more than one digit)
            currentNum = currentNum * 10 + (char - '0');
        } else if (char === '[') {
            // Push the current number and string to the stack
            stack.push([currentStr, currentNum]);
            currentStr = '';   // Reset current string for the next part
            currentNum = 0;    // Reset current number for the next part
        } else if (char === ']') {
            // Pop the number and previous string from the stack
            let [prevStr, repeatCount] = stack.pop();
            // Repeat the current string 'repeatCount' times and append to previous string
            currentStr = prevStr + currentStr.repeat(repeatCount);
        } else {
            // If it's a letter, add it to the current string
            currentStr += char;
        }
    }

    return currentStr;
};


const  s = "3[a]2[bc]";
console.log(decodeString(s));


// Example 1:
// Input: "3[a2[c]]"

// Start with an empty stack.
// Read 3: accumulate the number 3.
// Read [: push currentStr = "" and currentNum = 3 to the stack.
// Read a: add it to currentStr -> currentStr = "a".
// Read 2: accumulate the number 2.
// Read [: push currentStr = "a" and currentNum = 2 to the stack.
// Read c: add it to currentStr -> currentStr = "c".
// Read ]: pop currentStr = "a" and currentNum = 2 from the stack, repeat currentStr = "c" 2 times -> currentStr = "cc".
// Read ]: pop currentStr = "" and currentNum = 3 from the stack, repeat currentStr = "cc" 3 times -> currentStr = "accaccacc".
// Return "accaccacc".
// Output: "accaccacc"