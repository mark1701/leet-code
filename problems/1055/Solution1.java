class Solution {
    public int shortestWay(String s, String t) {       
        int res = 1;
        int j = 0;
        for(int i = 0; i < t.length(); i++){
            if(s.indexOf(t.charAt(i)) == -1) return -1;
            
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