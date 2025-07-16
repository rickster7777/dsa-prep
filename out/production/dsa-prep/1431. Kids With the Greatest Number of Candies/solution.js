var kidsWithCandies = function (candies, extraCandies) {
    let great = Math.max(...candies);
    console.log(great);

    const result = [];

    for (const n of candies) {
        if (n + extraCandies >= great) {
            result.push(true);
        } else {
            result.push(false);
        }
    }

    return result;
};


// more optimized approach by GPT
var kidsWithCandies = function(candies, extraCandies) {
    const greatest = Math.max(...candies);  // Find the max value only once
    return candies.map(candy => candy + extraCandies >= greatest);  // Directly map the result
};

const candies = [2, 3, 5, 1, 3], extraCandies = 3

console.log(kidsWithCandies(candies, extraCandies));