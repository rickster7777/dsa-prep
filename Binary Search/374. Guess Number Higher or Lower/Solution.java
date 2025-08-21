public class Solution {
    public int guessNumber(int n) {

        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int pick = guess(mid);

            if (pick == 0) {
                return mid;
            } else if (pick == -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private int guess(int mid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
/*
📌 Problem with int mid = (start + end) / 2;
This looks simpler, and it works for small values of start and end. But there's a hidden danger:

Integer Overflow.

In Java, integers are 32-bit. So, if start + end becomes larger than Integer.MAX_VALUE (which is 2,147,483,647), the result wraps around to a negative number due to overflow.

Example:
int start = 1_500_000_000;
int end = 1_600_000_000;
int mid = (start + end) / 2; // OVERFLOW! Bad result
✅ Why start + (end - start) / 2 is better:
This version avoids overflow because:

(end - start) is guaranteed to be smaller than or equal to end.

It adds a smaller number to start, so the result will stay within bounds.

Example:
int start = 1_500_000_000;
int end = 1_600_000_000;

// Safe calculation
int mid = start + (end - start) / 2;  // No overflow

 */