class Solution {
    
    public boolean isMatch(String s, String p) {
        int[][] memo = new int[s.length()+1][p.length()+1];
        for(int[] m : memo)
            Arrays.fill(m, -1);
        
        isMatch(s,p,0,0,memo);
        
        return memo[s.length()][p.length()] == 1;
    }
    
    private int isMatch(String s, String p, int sI, int pI, int[][] memo){

        if(memo[sI][pI] != -1) return memo[sI][pI];
        
        int res = 0;
        
        if(pI == p.length() && sI == s.length())
            memo[sI][pI] = 1;
        else if(pI == p.length())
            memo[sI][pI] = 0;
        else if(sI == s.length())
            memo[sI][pI] = (p.charAt(pI) == '*' && isMatch(s,p,sI,pI+1, memo) == 1) ? 1 : 0;
        else if(p.charAt(pI) == '?' || p.charAt(pI) == s.charAt(sI))
            memo[sI][pI] = isMatch(s,p,sI+1,pI+1, memo);
        else if(p.charAt(pI) == '*')
            memo[sI][pI] = (isMatch(s,p,sI+1, pI, memo) == 1 || isMatch(s,p,sI,pI+1, memo) == 1) ? 1 : 0;
        else
            memo[sI][pI] = 0;
        
        return memo[sI][pI];
    }
}