/*
input : g = [1,2,3], s = [1,1]
output : 1
explanation : you have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
*/

import java.util.Arrays;

public class Solution {
    //DP solution
    public int findContentChildren(int[] g, int[] s) {
        int[][] dp = new int[g.length + 1][s.length + 1];
        /*
        iF length of g is 3 and length of s is 2 Can you help me visualize how this will look like?

        int[][] dp = new int[4][3];

        Visual Layout of the 2D Array

        You can visualize dp like a table with 4 rows and 3 columns.

                j →
            0    1    2
           +----+----+----+
        0  | 0  | 0  | 0  |
           +----+----+----+
        1  | 0  | 0  | 0  |
           +----+----+----+
        2  | 0  | 0  | 0  |
           +----+----+----+
        3  | 0  | 0  | 0  |
           +----+----+----+
        ↑
        i

        Indexes:

        dp[0][0] dp[0][1] dp[0][2]
        dp[1][0] dp[1][1] dp[1][2]
        dp[2][0] dp[2][1] dp[2][2]
        dp[3][0] dp[3][1] dp[3][2]
        */
        for (int i = 1; i <= g.length; i++) {
            for (int j = 1; j <= s.length; j++) {
                if (g[i - 1] <= s[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[g.length][s.length];
    }

     // Greedy solution
    public int findContentChildrenGreedy(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // child pointer
        int j = 0; // cookie pointer

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++; // child satisfied
            }
            j++; // move to next cookie
        }

        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(solution.findContentChildren(g, s)); // Output: 1
        ////System.out.println(solution.findContentChildrenGreedy(g, s)); // Output: 1
    }
}

/*
But In the current scenario
G and S are not strings

int[] g = {1, 2, 3};
int[] s = {1, 1};

The key idea is: DP patterns don’t depend on strings specifically — they depend on sequences.
An int[], a string, a list… they are all ordered sequences, so the same DP table logic works.

Let’s apply it to your example.

int[] g = {1, 2, 3};
int[] s = {1, 1};

int[][] dp = new int[g.length + 1][s.length + 1];

1️⃣ What the DP table size becomes
g.length = 3
s.length = 2

So:
dp = new int[4][3]

Meaning:
rows = 4
columns = 3

2️⃣ How to visualize it
Even though they are arrays, we still treat them as prefixes of sequences.

Prefixes of g:
[]
[1]
[1,2]
[1,2,3]

Prefixes of s:

[]
[1]
[1,1]

So the table becomes:

        []   [1]   [1,1]
      +----+----+----+
[]    |    |    |    |
      +----+----+----+
[1]   |    |    |    |
      +----+----+----+
[1,2] |    |    |    |
      +----+----+----+
[1,2,3]|   |    |    |
      +----+----+----+

Row meaning:

first i elements of g

Column meaning:
first j elements of s

3️⃣ Why we still use +1

Because we need to represent the empty prefix.
Example cells:

dp[0][0] → [] vs []
dp[1][0] → [1] vs []
dp[0][2] → [] vs [1,1]
dp[3][2] → [1,2,3] vs [1,1]

Without the extra row/column we couldn't represent empty sequences.

4️⃣ Why loops start at 1

Typical loop:

for (int i = 1; i <= g.length; i++) {
    for (int j = 1; j <= s.length; j++) {

Because:

dp[0][*] → empty g prefix
dp[*][0] → empty s prefix

These rows/columns usually hold base case values.

5️⃣ Comparing arrays instead of characters

In string DP we write:
if (s1.charAt(i-1) == s2.charAt(j-1))

With arrays we simply do:
if (g[i-1] == s[j-1])

The idea is identical.

6️⃣ Example comparison inside DP

At:
dp[1][1]

We compare:
g[0] vs s[0]
1 vs 1

At:
dp[3][2]
We compare:

g[2] vs s[1]
3 vs 1

7️⃣ Mental model that always works

Whenever you see:

dp[n+1][m+1]

Think:
row i = first i elements of array1
col j = first j elements of array2

This works for:

strings
integer arrays
lists
characters
sequences

✅ So nothing actually changes when switching from strings to arrays.
Only the comparison changes:

charAt(i-1) → arr[i-1]


Recommended Learning Order

Follow this exact order:

1. Longest Common Subsequence
2. Longest Common Substring
3. Edit Distance
4. Delete Operation for Two Strings
5. Distinct Subsequences
6. Is Subsequence
7. Maximum Length of Repeated Subarray
8. Uncrossed Lines
9. Longest Palindromic Subsequence
10. Shortest Common Supersequence

If you solve these in this order, the DP table concept becomes almost automatic.

A Small Practice Trick (Highly Effective)

Before coding, always write this:

dp[i][j] =
answer for
first i elements of A
first j elements of B

Then ask:

What happens if elements match?
What happens if they don't?

That almost always reveals the recurrence.
*/