/*
LeetCode 994. Rotting Oranges
Problem Statement

You are given a grid where each cell contains:

0 → Empty cell
1 → Fresh Orange
2 → Rotten Orange

Every 1 minute,

a rotten orange infects all 4-directionally adjacent fresh oranges.

Directions allowed:

Up
Down
Left
Right

Not allowed:

Diagonal

Your task is to return:

Minimum minutes required so that every fresh orange becomes rotten
Return -1 if some fresh orange can never become rotten.
Example 1

Input

2 1 1
1 1 0
0 1 1

Initial Grid

2 1 1
1 1 0
0 1 1

Minute 0

Only one rotten orange.

Minute 1

2 2 1
2 1 0
0 1 1

The rotten orange spreads to

right
down

Minute 2

2 2 2
2 2 0
0 1 1

Minute 3

2 2 2
2 2 0
0 2 1

Minute 4

2 2 2
2 2 0
0 2 2

All oranges rotten.

Answer
4


Example 2

Input
2 1 1
0 1 1
1 0 1

Notice this orange

1

located here

2 1 1
0 1 1
1 0 1
^

It is blocked by empty cells.

Rotten oranges can never reach it.

Answer

-1

Example 3
0 2

There are

No fresh oranges

Nothing needs to rot.

Answer

0

Key Observation
The rot spreads exactly like a wave.

Example

Minute 0

    2

↓

Minute 1

  2 2
    2

↓

Minute 2

2 2 2
2 2 2

Every minute,

the infection spreads one level farther.

Which Algorithm?

Whenever you see

Minimum time
Spread
Infection
Fire spreading
Multi-source expansion
Shortest distance from many sources

Think

Multi-Source BFS
Why BFS?

BFS explores nodes

Level by Level

Exactly like time.

Example

Minute 0

R

↓

Minute 1

Neighbors

↓

Minute 2

Neighbors of neighbors

↓

Minute 3

Next neighbors

Each BFS level equals one minute.

Why Multi-Source?

Normally BFS starts from

One source

Example

A

Queue

[A]

Here,

we have

Multiple rotten oranges

Example

2 1 2
1 1 1
2 1 2

There are

4 rotten oranges

All of them start spreading at the same time.

So initially

Queue

[(0,0),
 (0,2),
 (2,0),
 (2,2)]

All rotten oranges are inserted into the queue before BFS starts.

This is called

Multi-Source BFS

High-Level Approach
Step 1

Traverse the entire grid once.

During traversal:

Count total fresh oranges.
Add every rotten orange's position to the BFS queue.

Example

2 1 1
1 2 0
0 1 2

Queue

[(0,0),
 (1,1),
 (2,2)]

Fresh count

4
Step 2

Start BFS.

Each iteration of the outer loop represents one minute.

Example

Queue

[(0,0),
 (1,1)]

Process all rotten oranges currently in the queue.

Those oranges infect their neighbors.

Step 3

For every rotten orange,

check all 4 directions.

Up

Down

Left

Right

If neighbor is

Fresh (1)

then

Make it rotten (2)
Decrease fresh count
Add it to the queue

These newly rotten oranges will spread infection in the next minute, not immediately.

Step 4

After processing all oranges currently in the queue,

one minute has passed.

minutes++
Step 5

Continue until

Queue becomes empty.

Step 6

Finally

If

Fresh count == 0

return

minutes

Otherwise

-1

because some fresh oranges were never reached.

Why Do We Count Fresh Oranges?

Suppose

2 1 1
0 1 1
1 0 1

The bottom-left orange is isolated.

Eventually,

Queue becomes empty.

But

Fresh oranges still remain.

Therefore

freshCount > 0

Return

-1
Why Process One BFS Level at a Time?

Suppose

Queue

Minute 0

[(0,0)]

Process

(0,0)

It infects

(0,1)

(1,0)

These newly rotten oranges should not infect others immediately in the same minute.

They must wait until the next minute.

That's why we first record the queue size:

int size = queue.size();

and process exactly size nodes before incrementing the minute counter.

Visualization

Initial

2 1 1
1 1 1
1 1 2

Minute 0

2 . .
. . .
. . 2

Minute 1

2 2 .
2 . 2
. 2 2

Minute 2

2 2 2
2 2 2
2 2 2

Notice how the infection spreads outward in layers. Each layer corresponds to one BFS level and one minute.

Intuition in One Sentence

Treat every initial rotten orange as a starting point, run Multi-Source BFS, where each BFS level represents one minute, and 
keep infecting adjacent fresh oranges until either all are rotten or no more can be reached.
*/
import java.util.*;

class Solution {

    public int orangesRotting(int[][] grid) {

        // ============================================================
        // STEP 1: Get grid dimensions
        // ============================================================
        int rows = grid.length;
        int cols = grid[0].length;

        // ============================================================
        // STEP 2: Create a queue for BFS
        // This queue stores the positions of all rotten oranges.
        // ============================================================
        Queue<int[]> queue = new LinkedList<>();

        // Count the total number of fresh oranges.
        int freshCount = 0;

        // ============================================================
        // STEP 3: Traverse the grid.
        //
        // - Add all rotten oranges to the queue.
        // - Count all fresh oranges.
        // ============================================================
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // ============================================================
        // STEP 4:
        // If there are no fresh oranges,
        // answer is 0 minutes.
        // ============================================================
        if (freshCount == 0) {
            return 0;
        }

        // ============================================================
        // STEP 5:
        // Possible movement directions
        //
        // Up, Down, Left, Right
        // ============================================================
        int[][] directions = {
                {-1, 0},   // Up
                {1, 0},    // Down
                {0, -1},   // Left
                {0, 1}     // Right
        };

        int minutes = 0;

        // ============================================================
        // STEP 6:
        // Perform Multi-Source BFS
        // ============================================================
        while (!queue.isEmpty()) {

            // Number of rotten oranges at the current minute
            int size = queue.size();

            boolean rottenThisMinute = false;

            // Process one BFS level
            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                // Check all four directions
                for (int[] dir : directions) {

                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // Check boundaries
                    if (newRow < 0 || newRow >= rows ||
                        newCol < 0 || newCol >= cols) {
                        continue;
                    }

                    // Only fresh oranges can become rotten
                    if (grid[newRow][newCol] == 1) {

                        // Make it rotten
                        grid[newRow][newCol] = 2;

                        // One less fresh orange remaining
                        freshCount--;

                        // Add newly rotten orange to queue
                        queue.offer(new int[]{newRow, newCol});

                        rottenThisMinute = true;
                    }
                }
            }

            // Increase time only if at least one orange became rotten
            if (rottenThisMinute) {
                minutes++;
            }
        }

        // ============================================================
        // STEP 7:
        // If fresh oranges still exist,
        // they were unreachable.
        // ============================================================
        if (freshCount > 0) {
            return -1;
        }

        return minutes;
    }

    public static void main(String[] args) {

    Solution sol = new Solution();

    // ============================================================
    // Example 1
    // ============================================================
    int[][] grid1 = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
    };

    System.out.println("Example 1:");
    System.out.println("Output: " + sol.orangesRotting(grid1));
    System.out.println("Expected: 4");

    // ============================================================
    // Example 2
    // ============================================================
    int[][] grid2 = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
    };

    System.out.println("\nExample 2:");
    System.out.println("Output: " + sol.orangesRotting(grid2));
    System.out.println("Expected: -1");

    // ============================================================
    // Example 3
    // ============================================================
    int[][] grid3 = {
            {0, 2}
    };

    System.out.println("\nExample 3:");
    System.out.println("Output: " + sol.orangesRotting(grid3));
    System.out.println("Expected: 0");

    // ============================================================
    // Example 4
    // All oranges are already rotten.
    // ============================================================
    int[][] grid4 = {
            {2, 2},
            {2, 2}
    };

    System.out.println("\nExample 4:");
    System.out.println("Output: " + sol.orangesRotting(grid4));
    System.out.println("Expected: 0");

    // ============================================================
    // Example 5
    // Fresh oranges but no rotten orange to start spreading.
    // ============================================================
    int[][] grid5 = {
            {1, 1},
            {1, 1}
    };

    System.out.println("\nExample 5:");
    System.out.println("Output: " + sol.orangesRotting(grid5));
    System.out.println("Expected: -1");
}
}