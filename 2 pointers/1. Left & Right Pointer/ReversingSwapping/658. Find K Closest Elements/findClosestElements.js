/**

var findClosestElements = function (arr, k, x) {
    let start = 0;
    let end = arr.length - 1;
    const result = [];
    while (start <= end) {
        if (Math.abs(arr[start] - x) < Math.abs(arr[end] - x)) {
            result.push(arr[start]);
            start++;
        } else if (Math.abs(arr[start] - x) === Math.abs(arr[end] - x)) {
            result.push(arr[start]);
            start++;
        } else {
            result.push(arr[end]);
            end--;
        }
    }

    result.sort((a,b)=> a -b);
    return result.slice(0, k);
};

Your current approach is a good start, but it's not optimal and has a few problems:

Issues in Your Code:
You're building the result array from both ends (start and end) until they meet — but this doesn't guarantee the k closest 
elements. You may collect more than k, and slice(0, k) at the end might cut off closer elements.

You're pushing both elements from start and end based on conditions, which might result in more than k elements, requiring 
sorting and slicing — adding extra complexity.
 */



var findClosestElements = function (arr, k, x) {
    let low = 0;
    let high = arr.length - k;

    while (low < high) {
        let mid = Math.floor((low + high) / 2);
        if (x - arr[mid] > arr[mid + k] - x) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }

    return arr.slice(low, low + k);
};
