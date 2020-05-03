class Solution {
    
    public String minRemoveToMakeValid(String s) {
        final char SKIP = '*';
        
        char[] chars = s.toCharArray();
        
        int opened = 0, closed = 0;
        
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == SKIP) continue;
            if(chars[i] == '(') opened++;
            if(chars[i] == ')') closed++;
            
            if(closed > opened) {
                chars[i] = SKIP;
                closed--;
            }
        }
        
        opened = 0;
        closed = 0;
        for(int i = chars.length-1; i >= 0; i--){
            if(chars[i] == SKIP) continue;
            if(chars[i] == '(') opened++;
            if(chars[i] == ')') closed++;
            
            if(opened > closed) {
                chars[i] = SKIP;
                opened--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != SKIP) sb.append(chars[i]);
        }
        return sb.toString();
    }
}