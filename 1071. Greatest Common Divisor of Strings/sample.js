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


//correct approach

/**
 * @param {string} str1
 * @param {string} str2
 * @return {string}
 */
var gcdOfStrings = function(str1, str2) {
    function gcd(a, b) {
        return b === 0 ? a : gcd(b, a % b);
    }

    // If str1 + str2 is not equal to str2 + str1, they cannot have a common divisor
    if (str1 + str2 !== str2 + str1) {
        return "";
    }

    // Find the GCD of the lengths of str1 and str2
    let gcdLength = gcd(str1.length, str2.length);

    // The potential result is the substring of str1 of length gcdLength
    return str1.substring(0, gcdLength);
};

//const str1 = "ABCDEF", str2 = "ABC";
const str1 = "ABABAB", str2 = "ABAB";
console.log(gcdOfStrings(str1, str2));