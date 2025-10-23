/*
 Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
 */

 //My sol It gave incorrect result
// class Solution {
//     public int romanToInt(String s) {
//         int sum = 0;

//         int i = 0;

//         while (i < s.length()) {

//             if (s.charAt(i) == 'I') {
//                 sum += 1;
//             }
//             else if (s.charAt(i) == 'V') {
//                 sum += 5;
//             }

//             else if (s.charAt(i) == 'X') {
//                 sum += 10;
//             }

//             else if (s.charAt(i) == 'L') {
//                 sum += 50;
//             }

//             else if (s.charAt(i) == 'C') {
//                 sum += 100;
//             }

//             else if (s.charAt(i) == 'D') {
//                 sum += 500;
//             }

//             else if (s.charAt(i) == 'M') {
//                 sum += 1000;
//             }

//             i++;
//         }

//         return sum;
//     }
// }

class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int n = s.length();
        
        // Iterate through the string
        for (int i = 0; i < n; i++) {
            // Get the value of the current Roman numeral character
            int currentValue = romanToValue(s.charAt(i));
            
            // Check if we need to subtract: if the current value is less than the next value
            if (i + 1 < n && currentValue < romanToValue(s.charAt(i + 1))) {
                sum -= currentValue;
            } else {
                sum += currentValue;
            }
        }
        
        return sum;
    }

    // Helper function to convert Roman numeral characters to their integer values
    private int romanToValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
