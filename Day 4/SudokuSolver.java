public class SudokuSolver {
    /*
     * Problem: Solve Sudoku board with backtracking
     * Approach: Find empty cells, try digits 1-9 recursively, backtrack if invalid
     * Time: O(9^(empty_cells)) worst case exponential
     * Space: O(empty_cells) recursion stack
     */
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    for (char d = '1'; d <= '9'; d++) {
                        if (isValid(board, r, c, d)) {
                            board[r][c] = d;
                            if (solve(board)) return true;
                            board[r][c] = '.'; // backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int r, int c, char d) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == d) return false;
            if (board[i][c] == d) return false;
            int br = 3 * (r / 3) + i / 3;
            int bc = 3 * (c / 3) + i % 3;
            if (board[br][bc] == d) return false;
        }
        return true;
    }
}
