class Solution {
    public int numMatchingSubseq(String s, String[] words) {
    
        int N = words.length;
        int M = s.length();
        
        int count = 0;
        
        List<Integer>[] map = new ArrayList[26];
        for(int i = 0; i < 26; i++) map[i] = new ArrayList();
        for(int i = 0; i < M; i++) map[s.charAt(i) - 'a'].add(i);        
        
        for(String w : words)
            if(isSubseq(s, w, map)) count++;
        
        return count;
    }
    
    private boolean isSubseq(String s, String w, List<Integer>[] map){
        int j=0;
        for(int i = 0; i < w.length(); i++){
            char c = w.charAt(i);
            List<Integer> idx = map[c - 'a'];
            if(idx.isEmpty()) return false;
                
            int k = Collections.binarySearch(idx, j);
            
            if(k < 0) k = -k -1;
            if(k == idx.size()) 
                return false;
            else
                j = idx.get(k);
            
            j++;
        }
        
        return true;
    }
}