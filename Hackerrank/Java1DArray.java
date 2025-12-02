import java.util.Scanner;

public class Java1DArray {
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        int n = game.length;
        int i = 0;
        
        while( i < n){
            
            if (i+leap > n){
                return true;
            } else if(game[i + 1] == 0){
                i++;                
            }else if(game[i + 1] == 1){
                return false;                
            }
            
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}




/*
 You're on the right track, but your implementation has several issues:

It only checks i + 1 and doesn’t consider leaping or moving backward.

It may cause index out of bounds errors.

It stops too early instead of exploring all possible moves.

To solve this correctly, we should use DFS (Depth-First Search) or BFS (Breadth-First Search) to explore all possible valid moves.

Here’s a fixed and correct version of your canWin function using recursion and proper logic:
 */

 public static boolean canWin(int leap, int[] game) {
    return canWin(leap, game, 0);
}

private static boolean canWin(int leap, int[] game, int i) {
    // Base cases
    if (i >= game.length) return true;  // We've jumped past the end — win!
    if (i < 0 || game[i] == 1) return false; // Invalid move or visited cell

    // Mark as visited
    game[i] = 1;

    // Explore all possible moves
    return canWin(leap, game, i + leap) ||  // Jump forward
           canWin(leap, game, i + 1)   ||   // Move forward
           canWin(leap, game, i - 1);       // Move backward
}


//Would you like me to show an iterative BFS version (avoiding recursion) as well?
/*
 import java.util.*;

public static boolean canWin(int leap, int[] game) {
    int n = game.length;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);

    while (!queue.isEmpty()) {
        int i = queue.poll();

        // If we've moved beyond the end, we win
        if (i >= n) return true;

        // Skip invalid or already visited positions
        if (i < 0 || game[i] == 1) continue;

        // Mark current position as visited
        game[i] = 1;

        // Add possible next moves
        queue.add(i + 1);     // move forward
        queue.add(i - 1);     // move backward
        queue.add(i + leap);  // jump forward
    }

    return false;
}

 */