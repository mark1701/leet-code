class Solution {
    
    boolean cycle;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        for(int[] p : prerequisites){
            graph.addEdge(p[1],p[0]);
        }
        
        boolean[] visited = new boolean[numCourses];
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> callStack = new ArrayDeque<>();
        
        for(int i = 0; i < visited.length; i++){
            if(visited[i] || cycle) continue;
            
            dfs(graph, i, visited, stack, callStack);
        }
        
        if(cycle) return (new int[0]);
        
        int[] coursesOrder = new int[numCourses];
        
        int pos = 0;
        while(!stack.isEmpty()){
            coursesOrder[pos] = stack.pop();
            pos++;
        }
        
        return coursesOrder;        
    }
    
    private void dfs(Graph graph, int vertex, boolean[] visited, Deque<Integer> stack, Deque<Integer> callStack){
        if(cycle) return;
        callStack.push(vertex);
        
        visited[vertex] = true;
        for(int w : graph.adj(vertex)){

            if(callStack.contains(w)){
                cycle = true;
                return;
            }
            if(visited[w]) continue;
            dfs(graph, w, visited, stack, callStack);
        }
        stack.push(vertex);
        callStack.pop();
    }
}

public class Graph{
    private ArrayList<Integer>[] vertices;
    
    public Graph(int n){
        vertices  = new ArrayList[n];
        for(int i = 0; i < n; i++){
            vertices[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int v, int w){
        vertices[v].add(w);
    }
    
    public List<Integer> adj(int v){
        return vertices[v];
    }
}