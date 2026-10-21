/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function (nums) {
    const dupCheck = new Set();

    for (const n of nums) {
        if (dupCheck.has(n)) {
            return true;
        }
        dupCheck.add(n);
    }
    return false;
};

const nums = [1, 2, 3, 1];
console.log(containsDuplicate(nums));

//Edge
//halcon
//xebia
//emirates

//Consultants
// Hays
// Robert Half

//Property
//Property finder
//dubbizle
//noon

// Linkedin
// Glassdoor
// bayt