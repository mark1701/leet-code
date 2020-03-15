class Solution {
    public boolean isMatch(String s, String p) {
        int[][] memo = new int[s.length()+1][p.length()+1];
        for(int[] m : memo){
            Arrays.fill(m, -1);
        }
        isMatch(s,p,0,0, memo);
        return memo[s.length()][p.length()] == 1;
    }
    
    private int isMatch(String s, String p, int sIdx, int pIdx,int[][] memo){
        if(memo[sIdx][pIdx] != -1) return memo[sIdx][pIdx];
        int res = 0;
        
        if(pIdx == p.length())
            res = sIdx == s.length() ? 1 : 0;
        else{
            boolean firstMatch = (sIdx < s.length() && (p.charAt(pIdx) == '.' || s.charAt(sIdx) == p.charAt(pIdx)));

            if(pIdx < p.length() -1 && p.charAt(pIdx+1) == '*')
                res = ((firstMatch && isMatch(s, p, sIdx+1,pIdx, memo) == 1) || isMatch(s, p, sIdx,pIdx+2, memo) == 1) ? 1 : 0;
            else
                res = (firstMatch && isMatch(s, p, sIdx+1,pIdx+1, memo) == 1) ? 1 : 0;
        }
        memo[sIdx][pIdx] = res;
        return res;
    }
}

