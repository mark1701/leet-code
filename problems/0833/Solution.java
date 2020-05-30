class Solution {
    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        if(s ==null || s.length() == 0) return null;
        int  N = indexes.length;

        if(N == 0) return s;
        
        Replacement[] replacements = new Replacement[N];
        for(int i = 0; i < N; i++){
            Replacement r = new Replacement(indexes[i], sources[i], targets[i]);
            replacements[i] = r;
        }
        
        Arrays.sort(replacements, (Replacement a, Replacement b) -> a.idx - b.idx);
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        for(int i = 0; i < s.length(); i++){            
            if(idx >= N || i != replacements[idx].idx){
                sb.append(s.charAt(i));
                continue;
            }
            
            Replacement r = replacements[idx];
            String source = r.source;
            String target = r.target;
            
            boolean match = occurs(s, source, i);
            
            if(match){
                sb.append(target);
                i += source.length() - 1; //remove 1 because the for loop will increase by 1 anyway
            }else {
                sb.append(s.charAt(i));
            }
            
            idx++;
        }
        
        return sb.toString();
    }
    
    private class Replacement{
        int idx;
        String source;
        String target;
        public Replacement(int idx, String s, String t){
            this.idx = idx;
            source = s;
            target = t;
        }
    }
    
    private boolean occurs(String s, String w, int pos){
        boolean match = true;
        for(int j = 0; j < w.length(); j++){
            if(w.charAt(j) != s.charAt(pos+j)){
                match = false;
                break;
            }
        }
        return match;  
    } 
}