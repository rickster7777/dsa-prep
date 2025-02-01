// const palind = (s)=>{
//     let str = ""
//     for(let j = s.length-1; j>=0; j--){
//         str += s[j];
//     }
//     return str;
// }

let str = "";
const palind = (s, index = s.length -1) => {
    if (index === 0) {
        str += s[index];
        return str;
    }

    str += s[index];
    palind(s, index - 1);

    return str;
}


const s = "123";
console.log(palind(s));



//In video he has written above code using swap function in c++.

// Summary:
// Java: No built-in swap function. You need to use a temporary variable to swap values.
// JavaScript: Uses destructuring assignment for swapping values easily.
// Python: Uses tuple unpacking to swap values efficiently