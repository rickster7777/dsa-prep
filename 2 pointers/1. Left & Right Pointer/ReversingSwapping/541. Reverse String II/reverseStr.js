// var reverseStr = function (s, k) {
//     let start = 0;
//     let rev = ""

//     for (let i = s.length; i >=0 ; i--) {
//         rev += s[i];
//     }


//     let parts = s.length/k;

//     while(j < Math.ceil(parts)){
//         if(j % 2 ===0){
//             s[j] = rev[j];
//             k--;
//         }else{

//         }
        
//     }
    
// };

/**
 not able to figure out how to reverse 2nd part of the string
 thinkig of dividing the reversed array in k parts and then picking alternate values from there
 */

 //Correct approach
//skip is handled through the loop


/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var reverseStr = function(s, k) {
    // Convert the string to an array for easy in-place manipulation
    const arr = s.split('');

    // Process every 2k characters
    for (let i = 0; i < arr.length; i += 2 * k) {
        // Set the start index
        let start = i;

        // Set the end index to either i + k - 1 or the last index of the array
        let end = Math.min(i + k - 1, arr.length - 1);

        // Reverse characters between start and end
        while (start < end) {
            // Swap characters
            let temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // Join the array back into a string
    return arr.join('');
};
