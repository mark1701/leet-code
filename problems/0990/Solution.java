class Solution {
    public boolean equationsPossible(String[] equations) {
	    Map<Character, Integer> map = new HashMap<>();
	    populateMap(map, equations);
        
	    int n = map.size();
       	Graph graph = new Graph(n);
	    addAllEdges(graph, map, equations);
        
        int[] cc = calculateCC(graph);
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

	private int[] calculateCC(Graph graph){
		int n = graph.size();

		int[] cc = new int[n];
		boolean[] visited = new boolean[n];

		int ccId = 0;
		for(int i = 0; i < n; i++){
			if(visited[i]) continue;
			dfs(graph, i, ccId, visited, cc);
			ccId++;
        }
        return cc;
    }

    private void dfs(Graph graph, int v, int ccId, boolean[] visited, int[] cc){
        visited[v] = true;
        cc[v] = ccId;
        for(int w : graph.adj(v)){
            if(visited[w]) continue;
            dfs(graph, w, ccId, visited, cc);
        }	
    }

	private void addAllEdges(Graph graph, Map<Character, Integer> map,  String[] equations){
        for(String e : equations){
            int v = map.get(e.charAt(0));
            int w = map.get(e.charAt(3));
            if(e.charAt(1) == '=')
                graph.addEdge(v, w);
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
        vertices[w].add(v);
    }

    public int size(){
        return vertices.length;
    }

    public List<Integer> adj(int v){
        return vertices[v];
    }
}
