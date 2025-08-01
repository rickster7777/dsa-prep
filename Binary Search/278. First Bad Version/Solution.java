// Mock VersionControl class for local testing
class VersionControl {
    // This should be overridden or implemented for testing
    boolean isBadVersion(int version) {
        return version >= 4;
    }
}

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while (start < end) {
            int mid = start + (end - start) / 2;

            boolean versionCheck = isBadVersion(mid);

            if (versionCheck) {
                // Unlike problem 374 here only mid is used instead of mid - 1 as per the problem statement.
                end = mid;
            } else {
                start = mid + 1;
            }

        }
        return start;
    }
}

/*
Example 1:

Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
Example 2:

Input: n = 1, bad = 1
Output: 1

Constraints:
1 <= bad <= n <= 231 - 1
 */