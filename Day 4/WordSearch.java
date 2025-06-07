public class WordSearch {
    /*
     * Problem: Check if a given word exists in a 2D board by moving horizontally or vertically adjacent cells
     * Approach: Recursively search in 4 directions, mark visited cells, backtrack if needed
     * Time: O(M*N*4^L), M*N = board size, L = length of word
     * Space: O(L) recursion stack + O(M*N) visited matrix
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int idx, int r, int c, boolean[][] visited) {
        if (idx == word.length()) return true;
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return false;
        if (visited[r][c] || board[r][c] != word.charAt(idx)) return false;
        visited[r][c] = true;
        // Recursively explore 4 directions using recursion
        boolean found = dfs(board, word, idx + 1, r + 1, c, visited) ||
                        dfs(board, word, idx + 1, r - 1, c, visited) ||
                        dfs(board, word, idx + 1, r, c + 1, visited) ||
                        dfs(board, word, idx + 1, r, c - 1, visited);
        visited[r][c] = false; // backtrack
        return found;
    }
}
