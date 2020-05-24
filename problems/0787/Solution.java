class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int[] f : flights){
            List<Edge> adjs = graph.getOrDefault(f[0], new ArrayList<>());
            adjs.add(new Edge(f[0],f[1],f[2]));
            graph.put(f[0], adjs);
        }
        
        PriorityQueue<Itinerary> queue = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        queue.add(new Itinerary(src, 0, k+1));
        
        while(!queue.isEmpty()){
            Itinerary it = queue.poll();

            if(it.city == dst) return it.cost;
            
            if(it.stops > 0){
                List<Edge> adjs = graph.getOrDefault(it.city, new ArrayList<>()); 
                for(Edge e : adjs){
                    queue.add(new Itinerary(e.to, it.cost+e.cost, it.stops-1));        
                }        
            }
        }
        
        return -1;
        
    }
    
    private class Itinerary{
    
        int city;
        int cost;
        int stops;
        
        public Itinerary(int city, int cost, int stops){
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }
    
    private class Edge{
        int from;
        int to;
        int cost;
        
        public Edge(int f, int t, int c){
            from = f;
            to = t;
            cost = c;
        }
    }
}