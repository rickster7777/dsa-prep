var reverseVowels = function (s) {
    let start = 0;
    let end = s.length - 1;

    while (start < end) {
        if ((s[start] === 'a' || s[start] === 'A' ||
            s[start] === 'e' || s[start] === 'E' ||
            s[start] === 'i' || s[start] === 'I' ||
            s[start] === 'o' || s[start] === 'O' ||
            s[start] === 'u' || s[start] === 'U')
            &&
            (s[end] === 'a' || s[end] === 'A' ||
                s[end] === 'e' || s[end] === 'E' ||
                s[end] === 'i' || s[end] === 'I' ||
                s[end] === 'o' || s[end] === 'O' ||
                s[end] === 'u' || s[end] === 'U')) {
            let temp;

            s[start] = temp;
            s[start] = s[end];
            s[end] = temp;

        } if ((s[start] !== 'a') || (s[start] !== 'A') ||
            (s[start] !== 'e') || (s[start] !== 'E') ||
            (s[start] !== 'i') || (s[start] !== 'I') ||
            (s[start] !== 'o') || (s[start] !== 'O') ||
            (s[start] !== 'u') || (s[start] !== 'U')) {
            start++;
        }
        if ((s[end] !== 'a') || (s[end] !== 'A') ||
            (s[end] !== 'e') || (s[end] !== 'E') ||
            (s[end] !== 'i') || (s[end] !== 'I') ||
            (s[end] !== 'o') || (s[end] !== 'O') ||
            (s[end] !== 'u') || (s[end] !== 'U')) {
            end--;
        }
    }

    return s;
};


const s = "IceCreAm"
console.log(reverseVowels(s));




var reverseVowels = function(s) {
    let start = 0;
    let end = s.length - 1;
    s = s.split('');  // Convert string to array to mutate characters

    const isVowel = (char) => {
        return 'aeiouAEIOU'.includes(char);
    };

    while (start < end) {
        // If both start and end are vowels, swap them
        if (isVowel(s[start]) && isVowel(s[end])) {
            let temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        // If start is not a vowel, move the start pointer
        else if (!isVowel(s[start])) {
            start++;
        }
        // If end is not a vowel, move the end pointer
        else if (!isVowel(s[end])) {
            end--;
        }
    }

    return s.join('');  // Convert the array back to string
};

const v = "IceCreAm";
console.log(reverseVowels(v));  // Output: "IcaCreAm"

