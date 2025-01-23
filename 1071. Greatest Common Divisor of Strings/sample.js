var gcdOfStrings = function (str1, str2) {
    // let ptr1 = 0, ptr2 = 0;
    const finalWord = [];
    let i = 0;

    while (i < str1.length || i < str2.length) {
        if (str1[i] === str2[i]) {
            if (finalWord[0] === str1[i]) {
                break;
            }
            finalWord.push(str1[i]);
        } else {
            if (str1[i] === undefined) {
                if (finalWord[0] === str2[i]) {
                    break;
                } else {
                    return "";
                }
            }

            if (str2[i] === undefined) {
                if (finalWord[0] === str1[i]) {
                    break;
                } else {
                    return "";
                }
            }
            break;
        }
        i++;
    }

    return finalWord.join("");
};

//const str1 = "ABCDEF", str2 = "ABC";
const str1 = "ABABAB", str2 = "ABAB";
console.log(gcdOfStrings(str1, str2));