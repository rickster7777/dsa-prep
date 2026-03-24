import java.util.Arrays;
/*
Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: ou have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.

Input: g = [1,2], s = [1,2,3]
Output: 2
Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
You have 3 cookies and their sizes are big enough to gratify all of the children,
You need to output 2.
*/
class Solution {
    public int findContentChildren(int[] g, int[] s) {
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
}
/*
🧠 Why This Works (Greedy Proof)
Matching smallest child first avoids wasting large cookies.
Sorting ensures we always try the best available fit.
This guarantees maximum matching.

⏱ Complexity
Time: O(n log n + m log m) (due to sorting)
Space: O(1) (ignoring sorting space)
*/