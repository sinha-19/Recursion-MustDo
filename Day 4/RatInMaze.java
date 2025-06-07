import java.util.*;
public class RatInMaze {
    /*
     * Problem: Find all paths from (0,0) to (N-1,N-1) in maze where 1 = open path, 0 = blocked
     * Approach: Recursively move in 4 directions, marking visited cells to avoid cycles
     * Time: O(4^(N^2)) worst-case exponential
     * Space: O(N^2) recursion stack + path storage
     */
    public List<String> findPaths(int[][] maze, int n) {
        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        if (maze[0][0] == 1) solve(maze, n, 0, 0, visited, "", res);
        return res;
    }
    private void solve(int[][] maze, int n, int r, int c, boolean[][] visited, String path, List<String> res) {
        if (r == n - 1 && c == n - 1) {
            res.add(path);
            return;
        }
        visited[r][c] = true;
        // Move Down
        if (r + 1 < n && maze[r + 1][c] == 1 && !visited[r + 1][c])
            solve(maze, n, r + 1, c, visited, path + "D", res);
        // Move Left
        if (c - 1 >= 0 && maze[r][c - 1] == 1 && !visited[r][c - 1])
            solve(maze, n, r, c - 1, visited, path + "L", res);
        // Move Right
        if (c + 1 < n && maze[r][c + 1] == 1 && !visited[r][c + 1])
            solve(maze, n, r, c + 1, visited, path + "R", res);
        // Move Up
        if (r - 1 >= 0 && maze[r - 1][c] == 1 && !visited[r - 1][c])
            solve(maze, n, r - 1, c, visited, path + "U", res);
        visited[r][c] = false; // backtrack
    }
}
