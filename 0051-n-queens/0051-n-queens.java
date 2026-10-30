import java.util.*;

class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        // Fill board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Start from row 0
        nQueens(board, 0, result);

        return result;
    }


    // Check if Queen can be placed
    public boolean isSafe(char[][] board, int row, int col) {

        // Check UP ↑
        for (int i = row - 1; i >= 0; i--) {

            if (board[i][col] == 'Q') {
                return false;
            }
        }


        // Check LEFT DIAGONAL ↖
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }


        // Check RIGHT DIAGONAL ↗
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }


        // Safe position
        return true;
    }


    // Place Queens
    public void nQueens(char[][] board, int row,
                        List<List<String>> result) {

        // Base case: all Queens placed
        if (row == board.length) {

            result.add(convert(board));

            return;
        }


        // Try every column
        for (int col = 0; col < board.length; col++) {

            // Check safe position
            if (isSafe(board, row, col)) {

                // PLACE Queen
                board[row][col] = 'Q';

                // Go to next row
                nQueens(board, row + 1, result);

                // REMOVE Queen (Backtracking)
                board[row][col] = '.';
            }
        }
    }


    // Convert char board into List<String>
    public List<String> convert(char[][] board) {

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {

            ans.add(new String(board[i]));
        }

        return ans;
    }
}