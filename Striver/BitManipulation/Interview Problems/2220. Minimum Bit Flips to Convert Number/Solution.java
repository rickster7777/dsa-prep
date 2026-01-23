// This problem is same as 461. Hamming Distance
/*
Example 1:
Input: start = 10, goal = 7
Output: 3
Explanation: The binary representation of 10 and 7 are 1010 and 0111 respectively.

We can convert 10 to 7 in 3 steps:
- Flip the first bit from the right: 1010 -> 1011.
- Flip the third bit from the right: 1011 -> 1111.
- Flip the fourth bit from the right: 1111 -> 0111.
It can be shown we cannot convert 10 to 7 in less than 3 steps. Hence, we return 3.


Example 2:
Input: start = 3, goal = 4
Output: 3
Explanation: The binary representation of 3 and 4 are 011 and 100 respectively. 

We can convert 3 to 4 in 3 steps:
- Flip the first bit from the right: 011 -> 010.
- Flip the second bit from the right: 010 -> 000.
- Flip the third bit from the right: 000 -> 100.
It can be shown we cannot convert 3 to 4 in less than 3 steps. Hence, we return 3.

*/




/*
Explanation:
To determine the minimum number of bit flips required to convert one number (start) to another (goal), we can use the XOR operation. 
The XOR operation between two bits results in 1 if the bits are different and 0 if they are the same. Therefore, by performing an XOR between start and goal, 
we can identify which bits differ between the two numbers.


✔ XOR produces 1 only where bits are different
✔ XOR produces 0 where bits are the same

Example Let:
start = 10;  // 1010
goal  = 7;   // 0111


Binary:
start = 1010
goal  = 0111
--------------
xor   = 1101


Meaning:
Bit positions with 1 in xor are the bits that differ
There are 3 differing bits

🧮 Step 2: Initialize counter
int count = 0;

This variable will store how many bits are set to 1
Each 1 in xor means one differing bit

🔁 Step 3: Loop while there are bits left
while (xor > 0) {

Loop continues as long as xor has at least one 1 bit

When xor becomes 0, all bits have been checked

🔍 Step 4: Check the least significant bit (LSB)
count += (xor & 1);

What (xor & 1) does
1 in binary → 0001
ANDing with 1 checks only the last bit

Last bit of xor	xor & 1
1	1
0	0

✔ If the last bit is 1, increment count
✔ If the last bit is 0, do nothing

🔄 Step 5: Right shift to move to the next bit
xor >>= 1;

What >>= 1 does
Shifts all bits one position to the right
Drops the last bit (already checked)
Brings the next bit into LSB position
*/

public class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal; // XOR to find differing bits
        int count = 0;

        // Count set bits in the XOR result
        while (xor > 0) {
            count += (xor & 1); // Increment count if the least significant bit is 1
            xor >>= 1; // Right shift to check the next bit
        }

        return count; // Return the total count of differing bits
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int start = 10;
        int goal = 7;
        int result = sol.minBitFlips(start, goal);
        System.out.println("Minimum bit flips required: " + result); // Output: 3
    }
}

/*
🔁 Full Loop Walkthrough (Example)
Initial
xor = 1101
count = 0

Iteration 1
xor & 1 → 1
count = 1
xor >>= 1 → 0110

Iteration 2
xor & 1 → 0
count = 1
xor >>= 1 → 0011

Iteration 3
xor & 1 → 1
count = 2
xor >>= 1 → 0001

Iteration 4
xor & 1 → 1
count = 3
xor >>= 1 → 0000


Loop ends (xor == 0)

✅ Final Result
count = 3


➡ There are 3 bits different between start and goal.
*/