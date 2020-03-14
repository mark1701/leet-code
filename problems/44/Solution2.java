class Solution {
    public boolean isMatch(String s, String p) {
        int pLen = p.length(), sLen = s.length();
        int pIdx = 0, sIdx = 0;
        int starIdx = -1, tempSIdx = -1;
        
        while(sIdx < sLen){
            if(pIdx < pLen && (p.charAt(pIdx) == s.charAt(sIdx) || p.charAt(pIdx) == '?')){
                pIdx++;
                sIdx++;
            }else if(pIdx < pLen && p.charAt(pIdx) == '*'){
                starIdx = pIdx;
                tempSIdx = sIdx;                
                pIdx++;
            }else if(starIdx == -1){
                return false;
            } else {
                pIdx = starIdx + 1;
                sIdx = tempSIdx + 1;
                tempSIdx = sIdx;
            }            
        }
        
        for(int i = pIdx; i < pLen; i++)
            if(p.charAt(i) != '*') return false;
        
        return true;
        
    }
}