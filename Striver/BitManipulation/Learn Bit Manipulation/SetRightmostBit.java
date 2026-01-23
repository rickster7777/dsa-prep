/*
Example 1:
Input:
n = 10 (binary: 1010)

Output:
11 (binary: 1011)
Explanation:
The rightmost unset bit is the least significant bit (LSB). Setting it to 1 gives 1011 = 11.

Example 2:
Input:
n = 7 (binary: 111)

Output:
7 (binary: 111)
Explanation:
All bits are already set to 1, so the number remains the same.


Algorithm:
Use bitwise OR with n + 1:
    result = n | (n + 1)
    n + 1 flips the rightmost 0 in n to 1, and all bits to the right become 0.
    Performing OR sets that bit to 1 while leaving other bits unchanged.
*/

public class SetRightmostBit {
    // Function to set the rightmost unset bit
    public static int setRightmostUnsetBit(int n) {
        // OR with n+1 sets the rightmost 0 to 1
        return n | (n + 1);
    }

    public static void main(String[] args) {
        // Sample input
        int n = 10; // binary: 1010

        // Call function
        int result = SetRightmostBit.setRightmostUnsetBit(n);

        // Print output
        System.out.println("Number after setting rightmost unset bit: " + result); // Output: 11
    }
}
