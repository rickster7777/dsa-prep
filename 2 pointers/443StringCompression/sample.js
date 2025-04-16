// var compress = function (chars) {
//     if (chars.length === 1) {
//         return 1;
//     }

//     let char = chars[0];
//     let count = 0;
//     const arr = [];

//     for (let i = 0; i < chars.length; i++) {
//         if (char === chars[i]) {
//             count++;
//         } else {

//             if (count === 1) {
//                 arr.push(char);
//             } else {
//                 arr.push(char, count);
//             }
//             char = chars[i];
//             count = 1;
//         }

//     }

//     arr.push(char, count);

//     for (let j = 0; j < arr.length; j++) {

//         if (isNaN(arr[j])) {
//             chars[j] = arr[j];
//         } else {
//             const ch = arr[j].toString().split("");
//             const chlength = ch.length;
//             let counter = 0;
//             while (counter < chlength) {
//                 chars[j] = ch[counter];
//                 j++;
//                 counter++;
//             }
//         }

//     }

//     chars.splice(arr.length, chars.length -1);
//     //return arr.length;
// };



// GPT solution took 2 ms.

/**
 * @param {character[]} chars
 * @return {number}
 */
var compress = function (chars) {
    let writeIndex = 0;  // Pointer for where to write in the array
    let readIndex = 0;   // Pointer for scanning through the array

    while (readIndex < chars.length) {
        let currentChar = chars[readIndex];  // The current character to compress
        let count = 0;

        // Count how many times the current character repeats consecutively
        while (readIndex < chars.length && chars[readIndex] === currentChar) {
            readIndex++;
            count++;
        }

        // Write the character
        chars[writeIndex++] = currentChar;
        /**
         * I was confused about the working of above line
         * Breaking It Down
            1️⃣ chars[writeIndex] = currentChar;
            This stores the current character (currentChar) at the writeIndex position.
            2️⃣ writeIndex++ (Post-increment)
            After writing the character, it increments writeIndex so that the next write happens at the 
            next position.
         */
        // If the character appears more than once, append the count
        if (count > 1) {
            let countStr = count.toString();
            for (let i = 0; i < countStr.length; i++) {
                chars[writeIndex++] = countStr[i];
            }
        }
    }
    // Return the new length of the array after compression
    return writeIndex;
};


// // 0 ms solution
// var compress = function(chars) {
//     let n = chars.length;
//     let idx = 0;
//     for (let i = 0; i < n; i++) {
//         let ch = chars[i];
//         let count = 0;
//         while (i < n && chars[i] === ch) {
//             count++;
//             i++;
//         }
//         if (count === 1) {
//             chars[idx++] = ch;
//         } else {
//             chars[idx++] = ch;
//             for (let digit of count.toString()) {
//                 chars[idx++] = digit;
//             }
//         }
//         i--;
//     }
//     chars.length = idx;
//     return idx;
// };


const chars = ["a", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b"];

console.log(compress(chars));
console.log(chars);
