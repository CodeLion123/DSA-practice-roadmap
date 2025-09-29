class Solution {
    /**
     * Time Complexity: O(m*n)
     * Space Complexity: O(m*n)
     * @input: heights
     * @output: list of coordinates
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null) return null;
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] isVisited1 = new boolean[m][n];
        boolean[][] isVisited2 = new boolean[m][n];
        Queue<Pair<Integer, Integer>> queue1 = new LinkedList<>();
        Queue<Pair<Integer, Integer>> queue2 = new LinkedList<>();
        for (int i=0;i<m; i++) {
            queue1.offer(new Pair<>(i,0));
            queue2.offer(new Pair<>(i,n-1));
        }
           
        for (int j=0; j<n; j++) {
            queue1.offer(new Pair<>(0,j));
            queue2.offer(new Pair<>(m-1,j));
        }
        bfs(heights, isVisited1, queue1, m, n);
        bfs(heights, isVisited2, queue2, m, n);
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++) {
                if(isVisited1[i][j] && isVisited2[i][j])
                    res.add(Arrays.asList(i,j));
            }
        return res;
    }

    /**
     * BFS approach
     * @param heights
     * @param isVisited
     * @param queue
     * @param m
     * @param n
     */
    public void bfs(int[][]heights, boolean[][] isVisited, Queue<Pair<Integer, Integer>> queue, int m, int n) {
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> rowCol = queue.poll();
            int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};            
            int r = rowCol.getKey();
            int c = rowCol.getValue();
            isVisited[r][c] = true;
            for (int[] direction: directions) {
                int i = r + direction[0];
                int j = c + direction[1];
                if (i>=0 && i<m && j>=0 && j<n && heights[i][j]>=heights[r][c] && !isVisited[i][j]) {
                    queue.offer(new Pair<>(i,j));
                    isVisited[i][j] = true;
                }
            }
        }
    }
}