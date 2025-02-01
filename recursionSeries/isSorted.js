const isSorted = (arr, index = 0) => {
    // Base case: If we reach the second-to-last element, return true
    if (index === arr.length - 1) {
        return true;
    }

    // Check if the current element is greater than the next one (ascending order check)
    if (arr[index] > arr[index + 1]) {
        return false; // Array is not sorted in ascending order
    }

    // Recursively check the next pair of elements
    return isSorted(arr, index + 1);
}

const isSortedDescending = (arr, index = 0) => {
    // Base case: If we reach the second-to-last element, return true
    if (index === arr.length - 1) {
        return true;
    }

    // Check if the current element is smaller than the next one (descending order check)
    if (arr[index] < arr[index + 1]) {
        return false; // Array is not sorted in descending order
    }

    // Recursively check the next pair of elements
    return isSortedDescending(arr, index + 1);
}

const checkSorted = (arr) => {
    // Check if the array is sorted in ascending or descending order
    if (isSorted(arr)) {
        return 'Ascending';
    } else if (isSortedDescending(arr)) {
        return 'Descending';
    } else {
        return 'Not Sorted';
    }
}

// Test cases
console.log(checkSorted([1, 2, 3, 4])); // Output: Ascending
console.log(checkSorted([4, 3, 2, 1])); // Output: Descending
console.log(checkSorted([1, 3, 2, 4])); // Output: Not Sorted
