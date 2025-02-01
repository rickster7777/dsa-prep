/*
In a technical interview, you've been given an array of numbers and you need to find a pair of numbers that are equal to the given target value. Numbers can be either positive, negative, or both. Can you design an algorithm that works in O(n)—linear time or greater?

let sequence = [8, 10, 2, 9, 7, 5]
let results = pairValues(sum: 11) = //returns (9, 2)
*/


const pairValues = (nums, k) => {
    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] === k) {
                return [nums[i], nums[j]];
            }
        }
    }
}

const pointer = (nums, k) => {

    let point = 0
    //for (let i = nums.length - 1; i >= 0; i--)
    let i = nums.length - 1
    while (i >= 0) {
        if (nums[point] + nums[i] === k) {
            return [nums[i], nums[point]];
        } else if (nums[point] + nums[i] < k) {
            point++;
        } else {
            i--
            //continue;
        }
    }
}





let sequence = [8, 10, 2, 9, 7, 5]
sequence.sort((a, b) => (a - b));
console.log("sequence ->", sequence);
let results = pointer(sequence, 11)
console.log(results);