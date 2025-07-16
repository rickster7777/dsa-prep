var canPlaceFlowers = function (flowerbed, n) {
    let i = 0;

    if (flowerbed[i] === 1) {
        i = 0;
    } else {
        i = 1;
    }

    while (i < flowerbed.length) {
        if ((i + 2 < flowerbed.length) && (flowerbed[i + 2] === 0) && n > 0) {
            if (i + 3 < flowerbed.length && (flowerbed[i + 3] === 0)) {
                n--;
            }

        }
        i = i + 2;
    }

    if (n === 0) {
        return true;
    } else {
        return false;
    }
};


// Above code failed for many cases.


/**
 * @param {number[]} flowerbed
 * @param {number} n
 * @return {boolean}
 */
var canPlaceFlowers = function (flowerbed, n) {
    let i = 0;

    // Traverse the flowerbed
    while (i < flowerbed.length) {
        // Check if the current plot is empty and the adjacent plots are empty
        if (flowerbed[i] === 0 &&
            (i === 0 || flowerbed[i - 1] === 0) &&  // Check left plot
            (i === flowerbed.length - 1 || flowerbed[i + 1] === 0)) {  // Check right plot
            flowerbed[i] = 1;  // Plant a flower here
            n--;  // Decrease the count of flowers to be planted
        }

        // If all flowers are planted, no need to continue
        if (n <= 0) {
            return true;
        }

        i++;  // Move to the next plot
    }

    // If after the loop we still need more flowers to be planted, return false
    return n <= 0;
};



const flowerbed = [1, 0, 0, 0, 0, 1], n = 2;
console.log(canPlaceFlowers(flowerbed, n));