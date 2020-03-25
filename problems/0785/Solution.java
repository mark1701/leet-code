class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int V = graph.length;
        int[] lens  = new int[V];
        
        boolean[] visited = new boolean[V];
        boolean res = true;
        for(int i = 0; i < V; i++){
            if(!visited[i])
                res &= dfs(graph, i, 1, lens, -1, visited);
        }
        return res;
    }

    private boolean dfs(int[][] graph, int node, int len, int[] lens, int parent, boolean[] visited){
        
        if(visited[node]){
            int diff = len - (lens[node]);
            return diff % 2 == 0;
        }
        
        visited[node] = true;
        lens[node] = len;

        if(graph[node].length == 0) return true;

        boolean res = true;
        for(int adj : graph[node]){
            if(adj == parent) continue;
            res &= dfs(graph, adj, len+1, lens, node, visited);
        }
        return res;
    }
}