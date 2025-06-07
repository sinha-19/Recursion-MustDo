import java.util.*;
public class NQueen {
    /*
     * Problem: Place N queens on an NxN board such that no two queens attack each other
     * Approach: Recursively place queens row by row, check safety of each placement
     * Time: O(N!) exponential due to backtracking
     * Space: O(N^2) for board + O(N) recursion stack
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        solve(0, board, res);
        return res;
    }
    private void solve(int row, char[][] board, List<List<String>> res) {
        if (row == board.length) {
            res.add(construct(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                solve(row + 1, board, res);
                board[row][col] = '.'; // backtrack
            }
        }
    }
    private boolean isSafe(int row, int col, char[][] board) {
        // Check same column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;
        // Check diagonal left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;
        // Check diagonal right
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;
        return true;
    }
    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) list.add(new String(row));
        return list;
    }
}
