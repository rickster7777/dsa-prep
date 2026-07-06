/*
Roman Numeral Values
Value	Symbol
1000	M
900	    CM
500	    D
400	    CD
100	    C
90	    XC
50	    L
40	    XL
10	    X
9	    IX
5	    V
4	    IV
1	    I

Notice that values like 900 (CM), 400 (CD), 90 (XC), 40 (XL), 9 (IX), 4 (IV) are included because Roman numerals use subtractive notation.

Example 1: Convert 3749

Start with:
3749

Step 1
Largest value ≤ 3749 is 1000 (M)

3749 - 1000 = 2749
Roman = M


Step 2
Again 1000 (M)

2749 - 1000 = 1749
Roman = MM

Step 3
Again 1000 (M)

1749 - 1000 = 749
Roman = MMM

Step 4
Largest value ≤ 749 is 500 (D)

749 - 500 = 249
Roman = MMMD

Step 5
Largest value ≤ 249 is 100 (C)

249 - 100 = 149
Roman = MMMDC


Step 6
Again 100 (C)

149 - 100 = 49
Roman = MMMDCC


Step 7
Largest value ≤ 49 is 40 (XL)

49 - 40 = 9
Roman = MMMDCCXL
Step 8

Largest value ≤ 9 is 9 (IX)

9 - 9 = 0
Roman = MMMDCCXLIX

Answer:
3749 = MMMDCCXLIX



Example 2: Convert 58
58

Largest ≤ 58 is 50 (L)

58 - 50 = 8
Roman = L

Largest ≤ 8 is 5 (V)

8 - 5 = 3
Roman = LV

Largest ≤ 3 is 1 (I)

3 - 1 = 2
Roman = LVI

Again:

2 - 1 = 1
Roman = LVII

Again:

1 - 1 = 0
Roman = LVIII

Answer:

58 = LVIII

*/
import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public String intToRoman(int num) {
        // Time Complexity: O(1) - Max 13 iterations (fixed Roman numeral values)
        // Space Complexity: O(1) - Fixed size arrays (13 elements each, constant)
        // Create arrays for values and their corresponding Roman numerals
        // Include subtractive cases (900, 400, 90, 40, 9, 4) in descending order
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        // Greedy approach: iterate through values from largest to smallest
        for (int i = 0; i < values.length; i++) {
            // While num is greater than or equal to current value
            while (num >= values[i]) {
                result.append(numerals[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }

    // HashMap version using LinkedHashMap to maintain order
    // Time Complexity: O(1) - Iterate through 13 fixed entries
    // Space Complexity: O(1) - Fixed size map (13 key-value pairs, constant)
    public String intToRomanHashMap(int num) {
        // LinkedHashMap maintains insertion order (descending by value)
        LinkedHashMap<Integer, String> romanMap = new LinkedHashMap<>();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");
        
        StringBuilder result = new StringBuilder();
        
        // Iterate through map entries in insertion order
        for (Map.Entry<Integer, String> entry : romanMap.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();
            
            // Greedily subtract and append symbol
            while (num >= value) {
                result.append(symbol);
                num -= value;
            }
        }
        
        return result.toString();
    }
}

