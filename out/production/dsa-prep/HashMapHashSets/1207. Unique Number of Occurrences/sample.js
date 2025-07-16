var uniqueOccurrences = function (arr) {

    // Step 1: Count the occurrences of each number

    const countMap = new Map();

    for (let num of arr) {
        countMap.set(num, (countMap.get(num) || 0) + 1);
    }

    // Step 2: Check if frequencies are unique
    const frequencies = new Set(countMap.values());

    // If the number of unique frequencies equals the number of different counts, return true
    return countMap.size === frequencies.size;
};


const arr = [1, 2, 2, 1, 1, 3];
console.log(uniqueOccurrences(arr));