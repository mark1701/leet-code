class Solution {
    public int numDistinct(String s, String t) {
        if(s == null || t == null) return 0;
        
        int sLen = s.length(), tLen = t.length();
       
        int[][] dp = new int[sLen+1][tLen+1];
        for(int i = 0; i < sLen+1; i++)
            dp[i][tLen] = 1;
        
        for(int i = sLen-1; i >= 0; i--){
            for(int j = tLen-1; j >= 0; j--){
                dp[i][j] = dp[i+1][j] + (s.charAt(i) == t.charAt(j) ? dp[i+1][j+1] : 0);
            }
        }
        
        return dp[0][0];
    }
}