/*
If you mean the count of "AG" subsequences problem, the key pattern is carry-forward counting.

Given:

"ABCGAG"

We want to count pairs (A, G) where A occurs before G.

The pattern

Scan left → right and maintain:

countA = number of A's seen so far
answer = number of AG pairs found

Whenever you see:

A → countA++
G → every previous A can pair with this G

So:

answer += countA

For:

A B C G A G

Walk through:

A → countA = 1

B → nothing

C → nothing

G → answer += 1
     answer = 1

A → countA = 2

G → answer += 2
     answer = 3

So there are 3 "AG" subsequences.

Pattern to recognize

This is another carry-forward pattern, but different from the running maximum:

Leaders / Replace Elements
→ right → left
→ carry maximum

AG Subsequence
→ left → right
→ carry count of A's
→ when G appears, add that count

The important insight is:

When you encounter G, every A you've already seen creates one new AG subsequence.

This gives O(n) time and O(1) space.

*/

public class Solution {

    public int countOfAg(String s){

        int countA = 0;
        int answer = 0;

        for (char c : s.toCharArray()) {
            if (c == 'A') {
                countA++;
            } else if (c == 'G') {
                answer += countA;
            }
        }

        return answer;
    }
}
