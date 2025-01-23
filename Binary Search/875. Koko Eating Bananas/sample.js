var minEatingSpeed = function (piles, h) {
    // Helper function to calculate the total hours required for a given eating speed
    function hoursNeeded(k) {
        let hours = 0;
        for (let i = 0; i < piles.length; i++) {
            hours += Math.ceil(piles[i] / k);
        }
        return hours;
    }

    let left = 1, right = Math.max(...piles);

    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        if (hoursNeeded(mid) <= h) {
            right = mid - 1; // Try smaller speed
        } else {
            left = mid + 1; // Try larger speed
        }
    }

    return left;
};
// piles = [3, 6, 7, 11], h = 8
piles = [30,11,23,4,20], h = 6
console.log(minEatingSpeed(piles, h));