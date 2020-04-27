class Solution {
    public int maxProduct(String[] words) {
    
        if(words == null || words.length == 0) return 0;
        
        int N = words.length;
        int max = 0;
        
        for(int i = 0; i < N-1; i++){
            
            String s = words[i];
            boolean[] map = new boolean[26];
            
            for(int k = 0; k < s.length(); k++){
                char c = s.charAt(k);
                map[c-'a'] = true;
            }
            
            for(int j = i+1; j < N; j++){
                
                String w = words[j];
                
                int len = s.length() * w.length();
                if(len <= max) continue;

                boolean commonChars = false;
                for(int k = 0; k < w.length(); k++){
                    char c = w.charAt(k);
                    if(map[c-'a']) {
                        commonChars = true;
                        break;
                    }
                }
                
                if(!commonChars){
                    max = len;
                }
            }
        }
        
        return max;
    }
}