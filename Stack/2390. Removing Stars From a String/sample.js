var removeStars = function (s) {
    let i = 0;
    let n = s.length;
    let start = 0;

    while (i < n) {
        if (s[i] !== "*") {
            start++;
            i++;
        } else if (s[i] === "*") {
            s[start] = "";
            start--;
            s[i] = "";
            i++;
        }
    }

    return s;
};


//GPT solution 
var removeStars = function (s) {

    const stack = [];

    for (const char of s) {
        if (char === "*") {
            stack.pop();
        } else {
            stack.push(char);
        }
    }

    return stack.join("");
};
const s = "leet**cod*e";
console.log(removeStars(s));