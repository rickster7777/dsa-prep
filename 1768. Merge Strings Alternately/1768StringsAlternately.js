// var mergeAlternately = function (word1, word2) {
//     let word = ''
//     // for (let i = 0; i < word1.length; i++) {

//     // }

//     let wlen1 = word1.length - 1;
//     let wlen2 = word2.length - 1;
//     let pt1 = 0;


//     while (wlen >= 0) {
//         word += word1[pt1] + word2[pt1]
//         pt1++;
//         wlen--;
//     }

//     // if(word.length < wlen1 + wlen2){
//     //     word+
//     // }
//     return word;
// };

// const word1 = "abc", word2 = "pqr";
// console.log(mergeAlternately(word1, word2));

// 4 January 2025
// var mergeAlternately = function (word1, word2) {
//     let tlength = word2.length - word1.length;

//     let word2Length = word2.length;
//     let word1Length = word1.length;

//     if (tlength < 0) {
//         tlength = Math.abs(tlength);
//         for (let i = 0; i < word2Length; i++) {
//             word2 += " "
//         }
//     }

//     if (tlength > 0) {
//         tlength = Math.abs(tlength);
//         for (let i = 0; i < word1Length; i++) {
//             word1 += " "
//         }
//     }

//    // let totalLength = word1.length + word2.length;

//     let finalWord = "";

//     for (let i = 0; i < word1.length; i++) {
//         finalWord += word1[i]+word2[i]
//     }

//     return finalWord;
// };


var mergeAlternately = function (word1, word2) {
    let ptr1 = word1.length;
    let ptr2 = word2.length;

    let wordSize = ptr2;

    if (ptr1 > ptr2) {
        wordSize = ptr1;
    }

    let i = 0;

    let finalWord = "";

    while (i < wordSize) {
        if (i < ptr1) {
            finalWord += word1[i];
        }

        if(i < ptr2){
            finalWord += word2[i];
        }
        i++;
    }
    return finalWord;
};
const word1 = "abc", word2 = "pqr";
console.log(mergeAlternately(word1, word2));

var mergeAlternately = function(word1, word2) {
    let ptr1 = 0, ptr2 = 0;
    let len1 = word1.length, len2 = word2.length;
    let finalWord = [];

    while (ptr1 < len1 || ptr2 < len2) {
        if (ptr1 < len1) {
            finalWord.push(word1[ptr1]);
            ptr1++;
        }

        if (ptr2 < len2) {
            finalWord.push(word2[ptr2]);
            ptr2++;
        }
    }

    return finalWord.join(''); // Convert the array back to a string
};
