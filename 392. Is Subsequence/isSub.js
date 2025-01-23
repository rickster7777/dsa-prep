var isSubsequence = function (s, t) {
    let sptr = 0;
    let i = 0;
    const result = [];

    while (i < t.length) {
        if (result.length >= s.length) {
            return true;
        }

        if(t[i] === s[sptr]){
            result.push(true);
            sptr++;
        }

        i++;
    }

    if(result.length === s.length){
        return true;
    } else{
        return false;
    }
};


const s = "abc", t = "ahbgdc";
console.log(isSubsequence(s, t));