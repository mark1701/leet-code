import java.util.*;
class Solution {
    public int minimumCost(int N, int[][] connections) {
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(N);
        for(int[] c : connections){
            int c1 = c[0] - 1;
            int c2 = c[1] - 1;
            int w = c[2];
            
            ewg.addEdge(new Edge(c1, c2, w));            
        }
        
        KruskalMST kru = new KruskalMST(ewg);

        Deque<Edge> edges = kru.edges();
        if(edges.size() < (ewg.V() - 1))
            return -1;
        else
            return kru.weight();
    }
}

class KruskalMST {

    private int weight;
    private Deque<Edge> mst = new ArrayDeque<Edge>();

    public KruskalMST(EdgeWeightedGraph G) {
        List<Edge> edges = G.edges();
	    Collections.sort(edges);

        UnionFind uf = new UnionFind(G.V());
	    int i = 0;
        while (i < edges.size() && mst.size() < G.V() - 1) {
            	Edge e = edges.get(i);
		        i++;
            	int v = e.either();
            	int w = e.other(v);
            	if (uf.find(v) != uf.find(w)) {
                	uf.union(v, w);
                	mst.offer(e);
                	weight += e.weight();
            	}
        }
    }

    public Deque<Edge> edges() {
        return mst;
    }

    public int weight() {
        return weight;
    }
}

class UnionFind {

	private int[] id;
	private int[] size;

	public UnionFind(int n){
		id = new int[n];
		size = new int[n];
		for(int i = 0; i < n; i++){
			id[i] = i;
			size[i] = 1;
		}
	}

	public int find(int i){
		return root(i);
	}

	private int root(int i){
		while(i != id[i]){
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}

	public void union(int v, int w){
		int i = root(v);
		int j = root(w);
		if(i == j) return;
		if(size[i] >= size[j]){
			id[j] = i;
			size[i] += size[j];
		}else{
			id[i] = j;
			size[j] += size[i];
		}		
	}
}

class EdgeWeightedGraph {

	List<Edge>[] vertices;
	List<Edge> edges;

	public EdgeWeightedGraph(int n){
		vertices = new ArrayList[n];
		for(int i = 0; i < n; i++){
			vertices[i] = new ArrayList<>();
		}

		edges = new ArrayList<>();
	}

	public void addEdge(Edge e){
		int v = e.either();
		vertices[v].add(e);
		int w = e.other(v);
		vertices[w].add(e);
		edges.add(e);
	}

	public int V(){
		return vertices.length;
	}

	public int E(){
		return edges.size();
	}

	public List<Edge> edges(){
		return edges;
	}

	public List<Edge> adj(int v){
		return vertices[v];
	}	
}

class Edge implements Comparable<Edge>{

	private final int v, w;
	private final int weight;

	public Edge(int v, int w, int weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int either(){
		return v;
	}

	public int other(int vertex){
		if(vertex == v)	
			return w;
		else 
			return v;
	}

	public int weight(){
		return weight;
	}

	public int compareTo(Edge that){
		if(this.weight() < that.weight()) return -1;
		else if(this.weight() > that.weight()) return 1;
		else return 0;		
	}
}