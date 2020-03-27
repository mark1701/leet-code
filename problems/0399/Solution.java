class Solution {
    double sol = -1;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, List<Edge>> adj = new HashMap<>();
        int idx = 0;
        for(List<String> e : equations){
            String v = e.get(0);
            String w = e.get(1);           
            
            double vw = values[idx];
            double wv = 1 / vw;
            
            addEdge(adj, v,w,vw);
            if(!v.equals(w))
                addEdge(adj, w,v,wv);  
            
            idx++;
        }
        
        double[] ans = new double[queries.size()];
        idx = 0;
        for(List<String> q : queries){
            String v = q.get(0);
            String w = q.get(1);

            sol = -1;            

            if(adj.containsKey(v) && adj.containsKey(w)){
                Map<String,Boolean> visited = new HashMap<>();
                dfs(adj, v, w, visited, 1);
            }

            ans[idx] = sol;
            idx++;
        }
        
        return ans;
    }
    
    private void dfs(Map<String, List<Edge>> adj, String v, String w, Map<String,Boolean> visited, double val){
        if(visited.get(v) != null)
            return;
        
        visited.put(v,true);
        
        if(v.equals(w)) {
            sol = val;
            return;
        }
        
        List<Edge> edges = adj.get(v);
        
        for(Edge e : edges){
            dfs(adj,e.to,w,visited, val*e.weight);
        }       
        
    }
    
    private void addEdge(Map<String, List<Edge>> adj, String v, String w, double weight){
        Edge edge = new Edge(v, w, weight);
        
        if(!adj.containsKey(v)){
                adj.put(v, new ArrayList<Edge>());
        }
        
        List<Edge> edges = adj.get(v);
        if(!edges.contains(edge))
                edges.add(edge);
    }   
    
    private class Edge {
        String from;
        String to;
        double weight;
        
        public Edge(String from, String to, double w){
            this.from = from;
            this.to = to;
            this.weight = w;
        }
        
        @Override
        public boolean equals(Object o){
            
            if(this == o) return true;
            Edge e = (Edge) o;
            if(this.from == e.from && this.to == e.to) return true;
            return false;
        }
        
        @Override
        public int hashCode(){
            int hc = 17;
            hc = hc + 31 * from.hashCode();
            hc = hc + 31 * to.hashCode();
            return hc;
        }
    }
}