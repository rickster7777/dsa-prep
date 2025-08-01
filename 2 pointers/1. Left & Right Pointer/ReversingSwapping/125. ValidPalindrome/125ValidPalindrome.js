// 20 Dec 2024
// var isPalindrome = function (s) {
//     let rev = "";

//     s = s.toLowerCase().replace(/[^a-z0-9]/g, '');

//     for (let i = s.length-1; i >= 0; i--) {
//         rev += s[i];
//     }

//     if (rev === s) {
//         return true;
//     } else {
//         return false;
//     }
// };


var isPalindrome = function (s) {
    s = s.toLowerCase().replace(/[^a-z0-9]/g, '');

    let start = 0;
    let end = s.length - 1;

    while (start < end) {
        if (s[start] !== s[end]) {
            return false;
        } else {
            start++;
            end--;
        }
    }
    return true;
};

let s = "A man, a plan, a canal: Panama";
// let s = "race a car"
console.log(isPalindrome(s));