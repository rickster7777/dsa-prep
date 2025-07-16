// var addMinimum = function (word) {
//     const isValid = "abc";
//     let i = 0;
//     let j = 0;
//     let output = 0;

//     while (i < word.length) {
//         if (word[i] === isValid[j]) {
//             i++;
//             j++;
//         } else {
//             j++;
//             output++;
//         }

//     }
//     return output;
// };



var addMinimum = function(word) {
    let count = 0;
    let i = 0;
    const expected = ['a', 'b', 'c'];

    while (i < word.length) {
        for (let j = 0; j < 3; j++) {
            if (i < word.length && word[i] === expected[j]) {
                i++; // matched the expected char
            } else {
                count++; // insert the missing char
            }
        }
    }

    return count;
};

