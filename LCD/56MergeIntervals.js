/**

### **Which One Should You Use?**
| Method | Modifies Original? | Performance | Use Case |
|--------|--------------------|-------------|----------|
| `splice()` | ✅ Yes | 🔵 Fast (In-place) | When modifying the array is fine |
| `filter()` | ❌ No | 🔵 Fast (Immutable) | When returning a new array is preferred |
| `slice()` | ❌ No | 🟡 Slightly slower | Readability, functional programming |
 */

/** 
var merge = function (intervals) {
    intervals.sort((a, b) => (a[0] - b[0]));


    if (intervals.length <= 1) {
        return intervals
    }
    //const size = intervals[0].length - 1;

    for (let i = 0; i < intervals.length - 1; i++) {
        if (intervals[i][1] >= intervals[i + 1][0]) {
            intervals[i] = [intervals[i][0], intervals[i + 1][1]]
            intervals.splice(i + 1, 1);
        }
    }
    return intervals;
};

const intervals = [[1,4],[0,4]];
console.log(merge(intervals));
*/

var merge = function (intervals) {
    if (intervals.length <= 1) return intervals;

    // Step 1: Sort intervals based on the starting time
    intervals.sort((a, b) => a[0] - b[0]);

    let merged = [intervals[0]]; // Initialize with the first interval

    for (let i = 1; i < intervals.length; i++) {
        let lastMerged = merged[merged.length - 1]; // Get last merged interval
        let current = intervals[i];

        // Step 2: Check for overlap
        if (lastMerged[1] >= current[0]) {
            // Merge intervals by updating the end time
            lastMerged[1] = Math.max(lastMerged[1], current[1]);
        } else {
            // Step 3: Add non-overlapping interval
            merged.push(current);
        }
    }

    return merged;
};

// Example Usage:
console.log(merge([[1,3],[2,6],[8,10],[15,18]])); // Output: [[1,6],[8,10],[15,18]]
console.log(merge([[1,4],[4,5]])); // Output: [[1,5]]
