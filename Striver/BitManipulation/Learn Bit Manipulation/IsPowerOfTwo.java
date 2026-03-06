/*
Power of two numbers have exactly one bit set in their binary form.
Subtracting one flips all bits after the set bit, creating no overlap with the original number.
A bitwise AND between the number and one less than itself will be zero only for powers of two.
This property allows for a fast check without looping or dividing.

 */
public class IsPowerOfTwo {

    int n  = 6;

    boolean isPower = n > 0 && (n & (n - 1)) == 0;
}

/*
Time Complexity: O(1), because bitwise operations take constant time.
Space Complexity: O(1), no extra space used.
*/

/*
1️⃣ Why this works (Core idea)

👉 A power of 2 has exactly ONE set bit (1) in binary.
Number	    Binary
1	        0001
2	        0010
4	        0100
8	        1000


2️⃣ What does n - 1 do?

Subtracting 1:
Turns the rightmost 1 into 0
Turns all bits after it into 1

Example
n     = 8  → 1000
n - 1 = 7  → 0111

3️⃣ What does n & (n - 1) do?

It removes the rightmost set bit.

Power of 2 example (8)
1000
& 0111
------
0000   → equals 0 ✅

Not a power of 2 example (10)
10  = 1010
9   = 1001

1010
&1001
-----
1000 ≠ 0 ❌

4️⃣ Why check n > 0?

Because:
0 & (-1) == 0 ❌ (would give wrong result)

Negative numbers aren’t powers of 2
So this avoids false positives.

5️⃣ Full Examples Table
| n | Binary | n-1  | n&(n-1) | Result   |
| - | ------ | ---- | ------- | ------   |
| 1 | 0001   | 0000 | 0000    | ✅      |
| 2 | 0010   | 0001 | 0000    | ✅      |
| 4 | 0100   | 0011 | 0000    | ✅      |
| 6 | 0110   | 0101 | 0100    | ❌      |
| 8 | 1000   | 0111 | 0000    | ✅      |

*/