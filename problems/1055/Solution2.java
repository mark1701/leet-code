class Solution {
    public int shortestWay(String s, String t) {
        int N = t.length();
        int M = s.length();
        
        List<Integer>[] idx = new ArrayList[26];
        for(int i = 0; i < 26; i++) idx[i] = new ArrayList();
        for(int i = 0; i < M; i++) idx[s.charAt(i) - 'a'].add(i);
        
        int count = 1;
        int pre = -1;
        for(int i = 0; i < N; i++){ 
            
            List<Integer> indices = idx[t.charAt(i) - 'a'];
            if(indices.isEmpty()) return -1;
            
            int k = findNext(indices, pre+1);
            if(k <= pre){
                count++;
                pre = -1;
                i--;
            } else{
                pre = k;
            }
  
        }
        return count;
    }
    
    private int findNext(List<Integer> indices, int pre){
        
        int lo = 0;
        int hi = indices.size() -1;
        
        while(lo < hi){
            int mid = lo + (hi - lo) /2;
            if(indices.get(mid) >= pre){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        if(lo >= indices.size()) return -1;
        return indices.get(lo);
    }
}