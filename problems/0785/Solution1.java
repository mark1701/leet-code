class Solution {
    
    private static final int RED = 1;
    private static final int BLACK = 2;
    
    public boolean isBipartite(int[][] graph) {
        
        int V = graph.length;
        boolean[] visited = new boolean[V];
        int[] colour = new int[V];
        
        for(int i = 0; i < V; i++){
            if(visited[i]) continue;
            Deque<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            colour[i] = RED;

            while(!queue.isEmpty()){

                int v = queue.poll();
                visited[v] = true;

                for(int w : graph[v]){
                    if(colour[w] == colour[v]) return false;

                    if(!visited[w]){
                        colour[w] = colour[v] == RED ? BLACK : RED;
                        queue.add(w);
                    }
                }
            }
        }
        return true;
    
    }

}