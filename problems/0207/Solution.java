class Solution {
    boolean cycle;
    
    public boolean canFinish(int n, int[][] prerequisites) {
        
        Graph graph = new Graph(n);
        for(int[] p : prerequisites)
            graph.addEdge(p[1],p[0]);        
        
        cycle = false;        
        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;            

            dfs(graph, i, visited, inStack);                           
        }       
        
        return !cycle;       
    }    
    
    private void dfs(Graph graph, int v, boolean[] visited, boolean[] inStack){                
                visited[v] = true;
                inStack[v] = true;
            
                for(int w : graph.adj(v)){
                    if(inStack[w]) 
                        cycle = true;

                    if(!visited[w])                    
                        dfs(graph, w, visited, inStack);                    
                }
                
                inStack[v] = false;
    }
    
    class Graph{
        
        List<Integer>[] adj;
        int V;
        
        public Graph(int n){
            V = n;
            adj = (List<Integer>[]) new ArrayList[n];
            for(int i=0; i < n; i++)
                adj[i] = new ArrayList<>();
        }
        
        public void addEdge(int v, int w){
            adj[v].add(w);
        }
        
        public List<Integer> adj(int v){
            return adj[v];
        }        
    }
}