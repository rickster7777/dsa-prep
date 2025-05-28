// My solution
// IT gave TLE

var increasingTriplet = function (nums) {

    for (let i = 0; i < nums.length; i++) {

        let num1 = nums[i];

        for (let j = i + 1; j < nums.length; j++) {

            if (nums[j] > num1) {
                let num2 = nums[j];

                for (let k = j + 1; k < nums.length; k++) {
                    if (nums[k] > num2) {
                        return true
                    }
                }
            }
        }
    }

    return false;
};


var increasingTriplet = function (nums) {
    let first = Infinity;  // Smallest number so far
    let second = Infinity; // Second smallest number so far

    for (let num of nums) {
        if (num <= first) {
            // Update first to be the smallest number
            first = num;
        } else if (num <= second) {
            // Update second to be the smallest number greater than first
            second = num;
        } else {
            // We found a number greater than both first and second
            return true;
        }
    }

    return false;
};

const nums = [20, 100, 10, 12, 5, 13];
console.log(increasingTriplet(nums));
