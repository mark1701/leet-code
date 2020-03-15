class Solution {
    public boolean equationsPossible(String[] equations) {
		//this solution was created only to try out the Kosaraju algorithm

	    Map<Character, Integer> map = new HashMap<>();
	    populateMap(map, equations);
        
	    int n = map.size();
       	Graph graph = new Graph(n);
	    addAllEdges(graph, map, equations);
        
        graph.reverse();
        
		boolean[] visited = new boolean[n];
        Deque<Integer> reversePostOrder = new ArrayDeque<>();
		for(int i = 0; i < n; i++){
			if(visited[i]) continue;
			reverseDFS(graph, i, visited, reversePostOrder);
        }
        
        graph.reverse();
        
        Arrays.fill(visited, false);
        int[] cc = new int[n];
        int ccId = 0;
        
        while(!reversePostOrder.isEmpty()){
            int v = reversePostOrder.pop();
            if(visited[v]) continue;            
            dfs(graph, v, visited, cc, ccId);
            ccId++;
        }
        
        return checkEquations(equations, map, cc);
    }

	private boolean checkEquations(String[] equations, Map<Character, Integer> map, int[] cc){
		for(String e : equations){
		    int v = map.get(e.charAt(0));
		    int w = map.get(e.charAt(3));
		    if(e.charAt(1) == '=' && cc[v] != cc[w])
			    return false;
            if(e.charAt(1) == '!' && cc[v] == cc[w])
			    return false;
        }
        return true;
    }

    private void dfs(Graph graph, int v, boolean[] visited, int[] cc, int ccId){
        visited[v] = true;
        cc[v] = ccId;
        for(int w : graph.adj(v)){
            if(visited[w]) continue;
            dfs(graph, w, visited, cc, ccId);
        }	
    }
    
    private void reverseDFS(Graph graph, int v, boolean[] visited, Deque<Integer> stack){
        visited[v] = true;
        for(int w : graph.adj(v)){
            if(visited[w]) continue;
            reverseDFS(graph, w, visited, stack);
        }	
        stack.push(v);
    }

	private void addAllEdges(Graph graph, Map<Character, Integer> map,  String[] equations){
        for(String e : equations){
            int v = map.get(e.charAt(0));
            int w = map.get(e.charAt(3));
            if(e.charAt(1) == '='){
                graph.addEdge(v, w);
                graph.addEdge(w, v);
            }
        }
    }

	private void populateMap(Map<Character, Integer> map, String[] equations){
		int itemId = 0;

		for(String e : equations){
			char c = e.charAt(0);
			if(!map.containsKey(c)){
				map.put(c, itemId);
				itemId++;
            }
            c = e.charAt(3);
			if(!map.containsKey(c)){
				map.put(c, itemId);
				itemId++;
            }
        }
    }
}

public class Graph{
	ArrayList<Integer>[] vertices;

	public Graph(int n){
		vertices = new ArrayList[n];
		for(int i = 0; i <  n; i++){
			vertices[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w){
        vertices[v].add(w);
    }

    public int size(){
        return vertices.length;
    }

    public List<Integer> adj(int v){
        return vertices[v];
    }
    
    public void reverse(){
        ArrayList<Integer>[] reversed = new ArrayList[size()];
        for(int v = 0; v < size(); v++)
            reversed[v] = new ArrayList<>();
            
        for(int v = 0; v < size(); v++){
            for(int w : adj(v)){
                reversed[w].add(v);
            }
        }
        
        vertices = reversed;
    }
}
