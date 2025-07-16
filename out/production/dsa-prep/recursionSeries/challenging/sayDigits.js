// const sayDigits = (n, arr) => {
//     // Base case: If n is 0
//     if (n === 0) {
//         return;
//     }


//     // Recursive case: F(n) = F(n-1) + F(n-2)
//     let digit = n % 10;  // Get the last digit
//     n = Math.floor(n / 10); 
    
//     sayDigits(n, arr);

//     console.log(arr[digit]); 


// }


const arr = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "niine"];
const ans = sayDigits(412, arr);
console.log(ans);  // Output will be four one two

