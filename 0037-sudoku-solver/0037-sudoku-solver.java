class Solution {

    // Check if digit can be placed
    public boolean isSafe(char[][] board, int row,
                          int col, char digit) {

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }

        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == digit) {
                return false;
            }
        }

        // Starting row and column of 3x3 grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        // Check 3x3 grid
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {

                if (board[i][j] == digit) {
                    return false;
                }
            }
        }

        // Digit is safe
        return true;
    }


    // Solve Sudoku using recursion
    public boolean sudokuSolver(char[][] board,
                                int row, int col) {

        // Base case - Sudoku completed
        if (row == 9) {
            return true;
        }

        // Find next cell
        int nextRow = row;
        int nextCol = col + 1;

        // If last column, go to next row
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // If cell already has a digit, skip it
        if (board[row][col] != '.') {
            return sudokuSolver(board, nextRow, nextCol);
        }

        // Try digits from 1 to 9
        for (char digit = '1'; digit <= '9'; digit++) {

            // Check if digit is safe
            if (isSafe(board, row, col, digit)) {

                // Place digit
                board[row][col] = digit;

                // Solve next cell
                if (sudokuSolver(board, nextRow, nextCol)) {
                    return true;
                }

                // Remove digit - Backtracking
                board[row][col] = '.';
            }
        }

        // No digit can be placed
        return false;
    }


    // LeetCode 37 main method
    public void solveSudoku(char[][] board) {

        // Start from first cell (0, 0)
        sudokuSolver(board, 0, 0);
    }
}