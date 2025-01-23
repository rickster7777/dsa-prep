/**
 * @param {number[]} spells
 * @param {number[]} potions
 * @param {number} success
 * @return {number[]}
 */
// var successfulPairs = function (spells, potions, success) {
//     const output = [];
//     for (let i = 0; i < spells.length; i++) {
//         let count = 0;
//         for (let j = 0; j < potions.length; j++) {
//             if (spells[i] * potions[j] >= success) {
//                 count++;
//             }
//         }
//         output.push(count);
//     }

//     return output;
// };
//Above ismy solution it gave TLE.

// best optimized solution copied from leetcode


var successfulPairs = function (spells, potions, success) {
    potions.sort((a, b) => a - b)
    for (let i = 0, n = potions.length; i < spells.length; i++) {
        let lo = 0, hi = n
        while (lo <= hi) {
            let mid = lo + hi >> 1
            if (spells[i] * potions[mid] < success)
                lo = mid + 1
            else
                hi = mid - 1
        }
        spells[i] = n - lo
    }
    return spells
};

const spells = [5, 1, 3], potions = [1, 2, 3, 4, 5], success = 7
console.log(successfulPairs(spells, potions, success));