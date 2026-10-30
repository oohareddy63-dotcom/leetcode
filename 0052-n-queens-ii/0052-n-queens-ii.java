class Solution {

    static int count = 0;

    // Check whether queen can be placed
    public static boolean isSafe(char board[][], int row, int col) {
        // Vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Place queens
    public static void nQueens(char board[][], int row) {
        // Base case
        if (row == board.length) {
            printBoard(board);
            count++;
            return;
        }

        // Try every column
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                // Place queen
                board[row][j] = 'Q';

                // Recursion
                nQueens(board, row + 1);

                // Backtracking
                board[row][j] = '.';
            }
        }
    }

    // Print board
    public static void printBoard(char board[][]) {
        System.out.println("------ Chess Board ------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // This is the entry point LeetCode uses to run your code
    public int totalNQueens(int n) {
        count = 0; 
        
        char board[][] = new char[n][n];

        // Initialize board exactly as you did in your main method
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        nQueens(board, 0);
        return count;
    }
}