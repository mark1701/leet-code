class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        K = K -1;
        Graph g = new Graph(N);
        for(int[] t : times){       
            g.addEdge(t[0]-1, t[1]-1, t[2]);
        }
        
        Dijkstra dj = new Dijkstra(g, K);
        
        int max = 0;
        for(int i = 0; i < N; i++){
            max = Math.max(max, dj.distanceTo(i));
        }
        
        return max < Integer.MAX_VALUE ? max : -1;
    }
    
    
    private class Dijkstra{

        int[] distance;
        Edge[] edgeTo;
        PriorityQueue<Vertex> minQueue;

        public Dijkstra(Graph g, int s){

            distance = new int[g.V()];
            Arrays.fill(distance, Integer.MAX_VALUE);

            minQueue = new PriorityQueue<>();

            distance[s] = 0;
            minQueue.add(new Vertex(s,0));
            while(!minQueue.isEmpty()){
                Vertex v = minQueue.poll();
                for(Edge e : g.adj(v.id)){
                    relax(e);				
                }
            }
        }

        private void relax(Edge e){
            int u = e.from;
            int w = e.to;
            if(distance[w] > distance[u] + e.weight){
                distance[w] = distance[u] + e.weight;

                Vertex v = new Vertex(w, distance[w]);
                if(minQueue.contains(v))
                    minQueue.remove(v);

                minQueue.add(v);			
            }
        }

        public int distanceTo(int v){
            return distance[v];
        }

        private class Vertex implements Comparable<Vertex>{
            int id;
            int dist;

            public Vertex(int id, int d){
                this.id = id;
                this.dist = d;	
            }

            @Override
            public boolean equals(Object o){
                if(this == o) return true;
                if(!(o instanceof Vertex)) return false;
                Vertex v = (Vertex) o;
                return this.id == v.id;
            }

            @Override
            public int hashCode(){
                return ((Integer) id).hashCode();
            }

            public int compareTo(Vertex that){
                return this.dist - that.dist;
            }
        }

    }

    private class Graph{
        List<List<Edge>> adj;
        int V;

        public Graph(int V){
            this.V = V;
            adj = new ArrayList<>(V);

            for(int i = 0; i < V; i++)
                adj.add(new ArrayList<>());
        }

        public void addEdge(int v, int w, int weight){
            adj.get(v).add(new Edge(v,w,weight));
        }

        public List<Edge> adj(int v){
            return adj.get(v);
        }

        public int V(){
            return V;
        }
    }
    
    private class Edge{

	int from;
	int to;
	int weight;

	public Edge(int v, int w, int weight){
		this.from = v;
		this.to = w;
		this.weight = weight;
	}	
}
}