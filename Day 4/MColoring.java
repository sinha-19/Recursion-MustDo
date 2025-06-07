public class MColoring {
    /*
     * Problem: Color graph with M colors so adjacent vertices have different colors
     * Approach: Recursively assign colors to each vertex and backtrack if conflicts occur
     * Time: O(M^V) exponential backtracking, V = vertices
     * Space: O(V) recursion stack + O(V) color array
     */
    public boolean graphColoring(boolean[][] graph, int m) {
        int V = graph.length;
        int[] colors = new int[V];
        return backtrack(0, colors, m, graph);
    }
    private boolean backtrack(int node, int[] colors, int m, boolean[][] graph) {
        if (node == graph.length) return true;
        for (int c = 1; c <= m; c++) {
            if (isSafe(node, colors, c, graph)) {
                colors[node] = c;
                if (backtrack(node + 1, colors, m, graph)) return true;
                colors[node] = 0; // backtrack
            }
        }
        return false;
    }
    private boolean isSafe(int node, int[] colors, int c, boolean[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] && colors[i] == c) return false;
        }
        return true;
    }
}
