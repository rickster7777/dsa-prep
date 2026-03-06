import java.util.Arrays;

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