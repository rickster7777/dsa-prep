let count = 0
const sumArray = (arr, index = 0) => {
    // Base case: If n is 0
    if (index === arr.length ) {
        return count;
    }

    // Recursive case: F(n) = F(n-1) + F(n-2)
    count = arr[index] + count
   // console.log(count);
    return sumArray(arr, index + 1);


}

const arr = [3, 2, 5, 1, 6];
// sum 17

const ans = sumArray(arr);
console.log(ans); 
