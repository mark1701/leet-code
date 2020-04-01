class Solution {
    public int shortestWay(String s, String t) {
        boolean[] map = new boolean[26];
        for(int i = 0; i < s.length(); i++)
            map[s.charAt(i) - 'a'] = true;
        
        int res = 1;
        int j = 0;
        for(int i = 0; i < t.length(); i++){
            if(!map[t.charAt(i) - 'a']) return -1;
            
            while(j < s.length() && s.charAt(j) != t.charAt(i)) j++;
            
            if(j == s.length()){
                res++;
                j = 0;
                i--;
            } else{
                j++;
            }
        }
        return res;
    }
    
   
}