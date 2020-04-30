class Solution {
    public boolean repeatedSubstringPattern(String s) {
    
        for(int l = 1; l <= s.length()/2; l++){
            if(s.length() % l != 0) continue;
            String sub = s.substring(0, l);
            int j = 0;
            boolean success = true;
            for(int i = l; i < s.length(); i++){
                if(sub.charAt(j) != s.charAt(i)){
                    success = false;
                    break;
                }
                if(j == l-1)
                    j = 0;
                else
                    j++;
            }
            if(success) return true;
        }
        return false;
    }
}