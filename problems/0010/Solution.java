class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s,p,0,0);
    }
    
    private boolean isMatch(String s, String p, int sIdx, int pIdx){
        if(pIdx == p.length()) return sIdx == s.length();
        
        boolean firstMatch = (sIdx < s.length() && (p.charAt(pIdx) == '.' || s.charAt(sIdx) == p.charAt(pIdx)));
        
        if(pIdx < p.length() -1 && p.charAt(pIdx+1) == '*')
            return (firstMatch && isMatch(s, p, sIdx+1,pIdx) || isMatch(s, p, sIdx,pIdx+2));
        else
            return firstMatch && isMatch(s, p, sIdx+1,pIdx+1);
    }
}