class Solution {
    public String minWindow(String s, String t) {
    
        int[] map = new int[128];
        for(char c : t.toCharArray())
            map[c]++;
        
        int count = t.length();
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        
        while(end < s.length()){
            
            char c = s.charAt(end);
            if(map[c] > 0)
                count--;
            
            map[c]--;
            end++;
            
            while(count == 0){
                
                if(end - start < minLen){
                    minLen = end - start;
                    minStart = start;                    
                }
                
                char cS = s.charAt(start);
                map[cS]++;
                
                if(map[cS] > 0)
                    count++;
                
                start++;                
            }            
            
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLen);    
    }
}