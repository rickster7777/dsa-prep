/**
 You can find the problem here: LeetCode Problem 198 - House Robber

This problem has a very similar structure to the "Maximum Sum of Adjacent Elements" problem, where you're tasked with finding the 
maximum sum of non-adjacent elements in an array.

[2,1,1,2]
for the above case myApproach didn't worked.
 */


const myApproach = (arr) => {

    let even_sum = 0;
    let odd_sum = 0;

    for (let i = 0; i < arr.length; i++) {
        if (i % 2 === 0) {
            even_sum += arr[i];
        } else {
            odd_sum += arr[i];
        }
    }

    return Math.max(even_sum, odd_sum);
}

const arr = [3, 2, 5, 10, 7];
console.log(myApproach(arr)); // Output: 15 (because 3 + 10 + 7 = 15)
