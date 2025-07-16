var shortestToChar = function (s, c) {
    const cs = [];
    const minValue = [];
    const result = [];

    for (let i = 0; i < s.length; i++) {
        if (s[i] === c) {
            cs.push(i);
        }
    }

    for (let i = 0; i < s.length; i++) {
        let minValue = Infinity;

        if (s[i] !== c) {
            for (let j = 0; j < cs.length; j++) {
                minValue = Math.min(minValue, Math.abs(i - cs[j]));
            }
            result.push(minValue);
        } else {
            result.push(0);
        }
    }

    return result;
};

/**
j =0;
while (i < s.length){
if s[i] !=c{
    j++;
}

if(j > 0){

}
}



✅ Your Current Solution
How it works:
First, you find all the indices where c occurs and store them in cs.

Then, for every character in s, you:

If it's not c, compute the minimum distance to every c in cs.

If it is c, distance is 0.

⏱ Time Complexity:
Outer loop: O(n)

Inner loop: O(k) (where k = number of c in s)

Total: O(n * k) — inefficient for long strings or many occurrences of c.
 */


/*
🚀 Optimized Solution (Two Pass — O(n) Time)
You can solve this in O(n) by scanning the string twice:
Left to right — track distance to the most recent c seen.
Right to left — track distance to the next c from the right.

✅ Optimized Code (with comments):
*/
var shortestToCharEff = function (s, c) {
    const n = s.length;
    const result = new Array(n).fill(Infinity);
    let prev = -Infinity;

    // Left to right pass
    // first pass ensures every position knows the closest c on the left.
    for (let i = 0; i < n; i++) {
        if (s[i] === c) {
            prev = i;
        }
        result[i] = Math.abs(i - prev);
    }

    // Right to left pass
    // second pass ensures it compares and keeps the closer c from the right
    prev = Infinity;
    for (let i = n - 1; i >= 0; i--) {
        if (s[i] === c) {
            prev = i;
        }
        result[i] = Math.min(result[i], Math.abs(i - prev));
    }

    return result;
};

/*
🧠 Why This Works:
The first pass ensures every position knows the closest c on the left.
The second pass ensures it compares and keeps the closer c from the right.
This guarantees the shortest distance from both directions efficiently.
*/

/**
why infinity is negative in first pass and positive in 2nd pass ?

from L to R
At the start, we haven’t seen c yet.
So, when you compute:

result[i] = Math.abs(i - prev); // when prev = -Infinity

That gives:
Math.abs(i - (-Infinity)) = Infinity
This makes sense — until you find a real c, the distance is unknown (effectively infinite).
As soon as you see c, prev = i, and all next positions get accurate distances.


from R to L
let prev = Infinity;
We’re going right to left, so at the start of this loop, we haven’t yet seen any c on the right.

When we hit a real c, we update prev = i, and now we can compute the distance to the closest c on the right.

result[i] = Math.min(result[i], Math.abs(i - prev));

| Pass          | Initial `prev` value | Why?                                   |
| ------------- | -------------------- | -------------------------------------- |
| Left to right | `-Infinity`          | No `c` seen yet; far left = undefined  |
| Right to left | `Infinity`           | No `c` seen yet; far right = undefined |

*/
shortestToCharEff("loveleetcode", "e");
// → [3,2,1,0,1,0,0,1,2,2,1,0]
