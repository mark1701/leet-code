class Solution {
    
    boolean[] visited;
    int[] discovery;
    int[] low;
    int[] parent;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        Graph graph = new Graph(n);
        for(List<Integer> c : connections)
            graph.addEdge(c);
        
        visited = new boolean[n];
        discovery = new int[n];
        low = new int[n];
        parent = new int[n];
        List<List<Integer>> res = new ArrayList<>();
        
        dfs(graph, 0, 0, res);       

        return res;        
    }
    
    private void dfs(Graph graph, int v, int time, List<List<Integer>> res){
        visited[v] = true;
        low[v] = discovery[v] = time;
        
        for(int w : graph.adj(v)){
            if (!visited[w]){
                
                parent[w] = v;
                dfs(graph, w, time+1, res);
                low[v] = Math.min(low[v], low[w]);
                
                if(low[w] > discovery[v]){
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(v);
                    bridge.add(w);
                    res.add(bridge);
                }                    
            } else if(parent[v] != w)
                low[v] = Math.min(low[v], discovery[w]);
        }
    }
}

public class Graph{
    
    List<Integer>[] vertices;
    
    public Graph(int n){
        vertices = new ArrayList[n];
        for(int i = 0; i < n; i++)
            vertices[i] = new ArrayList<>();
    }
    
    public void addEdge(List<Integer> e){
        int v = e.get(0);
        int w = e.get(1);
        vertices[v].add(w);
        vertices[w].add(v);
    }
    
    public List<Integer> adj(int v){
        return vertices[v];
    }
}