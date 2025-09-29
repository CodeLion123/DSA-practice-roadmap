class Solution {
    private static boolean isCyclicUtil(List<Integer>[] adj,
                                        int u,
                                        boolean[] visited,
                                        boolean[] recStack)
    {
        if (recStack[u])
            return true;

        if (visited[u])
            return false;

        visited[u] = true;
        recStack[u] = true;

        for (int v : adj[u]) {
            if (isCyclicUtil(adj, v, visited, recStack))
                return true;
        }
        recStack[u] = false;
        return false;
    }

    private static List<Integer>[] constructAdj(
        int V, int[][] edges)
    {
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }

        return adj;
    }

    public static boolean isCyclic(int V, int[][] edges)
    {
        List<Integer>[] adj = constructAdj(V, edges);
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]
                && isCyclicUtil(adj, i, visited, recStack))
                return true;
        }

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return !isCyclic(numCourses, prerequisites);
    }
}