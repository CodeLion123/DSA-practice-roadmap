class Solution {
    /**
     * BFS approach
     * @param grid
     * @param visited
     * @param row
     * @param col
     * @param m
     * @param n
     */
    public void bfs(char[][] grid, boolean[][] visited, int row, int col, int m, int n) {
        Queue<Pair<Integer, Integer>> myQueue = new LinkedList<>();
        myQueue.offer(new Pair<>(row,col));
        visited[row][col] = true;
        while (!myQueue.isEmpty()) {
            Pair<Integer, Integer> rowCol = myQueue.poll();
            int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            for (int[] direction: directions) {
                int i = rowCol.getKey() + direction[0];
                int j = rowCol.getValue() + direction[1];
                if (i>=0 && i<m && j>=0 && j<n && grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    myQueue.offer(new Pair<>(i,j));
                }
            }
        }

    }
    /**
     * Time Complexity: O(m*n)
     * Space Complexity: O(m*n)
     * @input: grid
     * @output: number of islands
     */
    public int numIslands(char[][] grid) {
        if (grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int island = 0;
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, i, j, m, n);
                    island++;
                }
            }
        return island;
    }
}