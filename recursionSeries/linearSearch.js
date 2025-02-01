const linearSearch = (arr, target, index = 0) => {
    // Base case: If index is equal to the length of the array then further evaluation should be stopped.
    if (index === arr.length) {
        return -1;
    }

    
    if (arr[index] === target)
        return index;

    return linearSearch(arr, target, index + 1);


}

const arr = [3, 2, 5, 1, 6];
target = 0;

const ans = linearSearch(arr, target);
console.log(ans);
