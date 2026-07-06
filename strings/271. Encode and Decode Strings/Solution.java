/*
Example 1
Input: ["hello", "world"]

Encoded: 5#hello5#world

Decoded: ["hello", "world"]

Example 2

Input: ["leet", "code", ""]
Encoded: 4#leet4#code0#
Decoded: ["leet", "code", ""]

Example 3 (strings contain #)

Input:["ab#cd", "x#y#z"]
Encoded: 5#ab#cd5#x#y#z
Decoded: ["ab#cd", "x#y#z"]

Example 4 (empty list)

Input: []
Encoded:""
Decoded: []

Example 5 (multiple empty strings)

Input: ["", "", ""]
Encoded: 0#0#0#
Decoded: ["", "", ""]
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String encode(String[] strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }


    public static String[] decode(String s) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            // 1. Extract length
            int count = 0;
            while (i < s.length() && s.charAt(i) != '#') {
                count = count * 10 + (s.charAt(i) - '0');
                i++;
            }
            i++; // Skip the '#'
            // 2. Extract string
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < count; j++) {
                sb.append(s.charAt(i++));
            }
            decoded.add(sb.toString());
        }
        return decoded.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] input = {"hello", "world"};
        String encoded = encode(input);
        System.out.println("Encoded: " + encoded); // Output: 5#hello5#world

        String[] decoded = decode(encoded);
        System.out.print("Decoded: [");
        for (int i = 0; i < decoded.length; i++) {
            System.out.print("\"" + decoded[i] + "\"");
            if (i < decoded.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]"); // Output: ["hello", "world"]

        String[] input2 = {"leet", "code", ""};
        String encoded2 = encode(input2);
        System.out.println("Encoded: " + encoded2); // Output: 4#leet4#code0#

        String[] decoded2 = decode(encoded2);
        System.out.print("Decoded: [");
        for (int i = 0; i < decoded2.length; i++) {
            System.out.print("\"" + decoded2[i] + "\"");
            if (i < decoded2.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]"); // Output: ["leet", "code", ""]
    }
}
