class Solution {
    int[] id;
    int[] size;
    
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
    
        if(words1 == null && words2 == null) return true;
        if(words1 == null) return false;
        if(words2 == null) return false;
        
        if(words1.length == 0 && words2.length == 0) return true;
        if(words1.length != words2.length) return false;
    
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for(List<String> p : pairs){
            if(!map.containsKey(p.get(0)))
                map.put(p.get(0), count++);
            if(!map.containsKey(p.get(1)))
                map.put(p.get(1), count++);                
        }
        
        id = new int[count];
        size = new int[count];
        Arrays.fill(size, 1);
        
        for(int i = 0; i < count; i++){
            id[i] = i;
        }
        
        for(List<String> p : pairs){
             int a = map.get(p.get(0));
             int b = map.get(p.get(1));
             
             if(!connected(a,b))
                 union(a,b);
        }
        
        for(int i = 0; i < words1.length; i++){
            if(words1[i].equals(words2[i])) continue;
            
            Integer a = map.get(words1[i]);
            Integer b = map.get(words2[i]);
             
            if(a == null || b == null || !connected(a,b)) return false;                
        }
        
        return true;
    }
    
    private int root(int i){
        while(id[i] != i){ 
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    
    private void union(int p, int q){
        int i = root(p);
        int j = root(q);
        
        if(size[i] >= size[j]){
            id[j] = id[i];
            size[j] += size[i];
        }else{            
            id[i] = id[j];
            size[i] += size[j];
        }
    }
    
    private boolean connected(int i, int j){
        return root(i) == root(j);
    }
}