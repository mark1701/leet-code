class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int V = 0;
        for(int[] edge : edges)
            V = Math.max(V, Math.max(edge[0],edge[1]));
        
        UnionFind uf = new UnionFind(V);
        
        int[] res = null;
        
        for(int[] edge : edges){
            if(!uf.connected(edge[0], edge[1]))
                uf.union(edge[0], edge[1]);
            else{
                res = edge;
                break;
            }
        }        
        
        return res;
    }
    
    private class UnionFind{
        
        int[] parent;
        int[] size;
        
        public UnionFind(int v){
            size = new int[v+1];
            parent = new int[v+1];
            for(int i = 1; i <= v; i++){
                parent[i] = i;        
                size[i] = 1;
            }
        }        
        
        public boolean connected(int v, int w){
            return root(v) == root(w);
        }
        
        private int root(int v){            
            while(parent[v] != v){
                parent[v] = parent[parent[v]];
                v = parent[v];                
            }
            return v;
        }
        
        public void union(int v, int w){
            int i = root(v);
            int j = root(w);
            if(size[i] >= size[j]){
                parent[j] = i;
                size[i] += size[j];
            }
            else{
                parent[i] = j;
                size[j] += size[i];
            }
        }        
    }
}