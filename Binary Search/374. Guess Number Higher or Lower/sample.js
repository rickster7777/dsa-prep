/**
 * @param {number} n
 * @return {number}
 */
var guessNumber = function (n) {
    let start = 1;  // Start of the range (assuming 1 is the minimum)
    let end = n;    // End of the range

    while (start <= end) {
        // Find the mid index
        let mid = Math.floor((start + end) / 2);

        let pick = guess(mid);

        if (pick === 0) {
            return mid;
        } else if (pick > 0) {
            start = mid + 1;  // Guess is too low, move the start to mid + 1
        } else {
            end = mid - 1;    // Guess is too high, move the end to mid - 1
        }
    }
};


const n = 10;
console.log(guessNumber(n));

