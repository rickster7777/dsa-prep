package strings.6. Zigzag Conversion;
/*
My approach 
I was trying to think in terms of a 2d matrix which was incorrect 

2 loops are to be managed rows and string

int n = s.length();
cols can be calc based on number of rows and string length

(0,0)		(0, 3)			(0, 6)
(1,0)	  (1, 2) (1, 3) 	(1, 5)	(1, 6)
(2,0)(2, 1)	  (2, 3) (2, 4)	
(3,0)		  (3, 3)	
*/
/*
Zigzag Conversion — Approach

The key idea is: don't actually rearrange characters in a 2D matrix. Just simulate the movement between rows.

Suppose:

s = "PAYPALISHIRING"
numRows = 3

The characters move like:

P   A   H   N
A P L S I I G
Y   I   R
Think of it as moving a pointer between rows

Start at row 0.

For each character:

Put the character into the current row.
Move down one row.
When you reach the bottom row, change direction → move up.
When you reach the top row, change direction → move down again.
At the end, concatenate all rows.

So conceptually:

row 0  →  P       A       H       N
row 1  →  A   P   L   S   I   I   G
row 2  →  Y       I       R

You maintain just two things:

currentRow
direction

where direction can be:

+1  → moving down
-1  → moving up
Important edge case

If:

numRows == 1

or

numRows >= s.length()

there is no zigzag to perform, so return s directly.

Complexity
Time: O(n) — visit every character once.
Space: O(n) — characters are stored across the rows.

The main insight to remember is:

Create one string/buffer for each row and simulate the up/down movement.

If you want to solve it yourself, I can guide you step-by-step Socratically, without giving you the code.
*/

public class Solution {
    public String convert(String s, int numRows) {

    // Edge case
    if (numRows == 1 || numRows >= s.length()) {
        return s;
    }

    // STEP 1: One StringBuilder for each row (have not used it before)
    StringBuilder[] rows = new StringBuilder[numRows];

    for (int i = 0; i < numRows; i++) {
        rows[i] = new StringBuilder();
    }

    // STEP 2: Simulate the zigzag movement only these two variables are needed.
    int currentRow = 0;
    int direction = 1; // 1 = down, -1 = up

    //STEP 3: Process each character
    for (char c : s.toCharArray()) {

        // Put character in current row
        rows[currentRow].append(c);

        //STEP 3.1: Change direction at top/bottom
        // This is the key insight: we only need to know when to change direction, 
        // not the actual 2D coordinates.
        // How direction can be changed? When we reach the top row (0) or the bottom row (numRows - 1), we reverse the direction.
        if (currentRow == 0) {
            direction = 1;
        } else if (currentRow == numRows - 1) {
            direction = -1;
        }

        // Move to next row
        currentRow += direction;
    }

    // Combine all rows
    StringBuilder result = new StringBuilder();

    for (StringBuilder row : rows) {
        result.append(row);
    }

    return result.toString();
}

public static void main(String[] args) {
    Solution sol = new Solution();
    String s = "PAYPALISHIRING";
    int numRows = 3;
    String converted = sol.convert(s, numRows);
    System.out.println(converted); // Output: "PAHNAPLSIIGYIR"

    int numRows2 = 4;
    String converted2 = sol.convert(s, numRows2);
    System.out.println(converted2); // Output: "PINALSIGYAHRPI"
}
