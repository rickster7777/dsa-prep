package BitManipulation;
/*
Example 1
Input: n = 5, i = 0
Output: true
Explanation: Binary representation of 5 is 101.
The 0-th bit from LSB is set (1).

Example 2
Input: n = 10, i = 1
Output: true
Explanation: Binary representation of 10 is 1010.
The 1-st bit from LSB is set (1).
*/
public class Bitset {
    public static boolean checkIthBit(int n, int i) {
        // Your code goes here

        return (n & (1 << i)) != 0;
    }

    public static void main(String[] args) {
        int n = 16;
        int i = 3;

        System.out.println(Bitset.checkIthBit(n, i));
    }
}
