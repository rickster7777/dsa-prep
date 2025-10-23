import java.util.HashSet;
import java.util.Set;


//My approach not checking subgrids
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> setRow = new HashSet<>();
            Set<Character> setCol = new HashSet<>();

            for (int j = 0; j < board.length; j++) {

                if(setRow.contains(board[i][j]) && Character.isDigit(board[i][j])){

                    return false;
                } else {
                    setRow.add(board[i][j]);
                }

                if(setCol.contains(board[j][i]) && Character.isDigit(board[j][i]) ){

                    return false;
                } else {
                    setCol.add(board[j][i]);
                }
            }
        }

        return true;
    }

    // Fixed approach with subgrid checks
    public boolean isValidSudokugrids(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue;
                
                // Check row
                if (rows[i].contains(num)) return false;
                rows[i].add(num);
                
                // Check column
                if (cols[j].contains(num)) return false;
                cols[j].add(num);
                
                // Check box
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (boxes[boxIndex].contains(num)) return false;
                boxes[boxIndex].add(num);
            }
        }
        
        return true;
 
 
    }

    //Compactapproach with one set and keys
    public boolean isValidSudokuKeys(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue;

                // Build unique keys for row, column, and box
                String rowKey = num + " in row " + i;
                String colKey = num + " in col " + j;
                String boxKey = num + " in box " + (i / 3) + "-" + (j / 3);

                // If any already exists → invalid
                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }
        return true;
    }
}