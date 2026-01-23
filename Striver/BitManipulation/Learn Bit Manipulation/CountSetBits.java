/*
Example 1:
Input: n = 5
Output: 2
Explanation: The binary representation of 5 is 101, which has 2 set bits.

Example 2:
Input: n = 15
Output: 4
Explanation: The binary representation of 15 is 1111, which has 4 set bits.

Algo
Initialize a counter to zero.
While the number is greater than zero:
Check if the least significant bit (LSB) is 1 by performing bitwise AND with 1.
If LSB is 1, increment the counter.
Right shift the number by one bit.
Return the counter.
*/
public class CountSetBits {

    // Brute Force
    public static void main(String[] args) {
        int count = 0; // Variable to store the count of set bits
        int count2 = 0;
        int n = 29;

        // Brute force
        // Step 1: Count the number of set bits using bitwise operations
        while (n > 0) {
            count += (n & 1); // Check if the least significant bit is set (1)
            n >>= 1; // Right shift n by 1 to process the next bit
        }
        System.out.println(count);

        // Optimized approach
        while (n > 0) {
            n &= (n - 1); // Turn off the rightmost set bit
            count2++; // Increment the count
        }
        System.out.println(count2);

    }
}
