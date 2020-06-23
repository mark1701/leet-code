class Solution {
    public int minimumDeleteSum(String s1, String s2) {
                
        int M = s1.length();
        int N = s2.length();
        
        int[][] dp = new int[M+1][N+1];
        dp[M][N] = 0;
        
        for(int j = N-1; j >= 0; j--)
            dp[M][j] = dp[M][j+1] + s2.charAt(j);
        for(int i = M-1; i >= 0; i--)
            dp[i][N] = dp[i+1][N] + s1.charAt(i);
        
        for(int i = M-1; i >= 0; i--)
            for(int j = N-1; j >= 0; j--){
                dp[i][j] = dp[i+1][j+1];
                if(s1.charAt(i) != s2.charAt(j))
                    dp[i][j] = Math.min(s1.charAt(i) + dp[i+1][j], s2.charAt(j) + dp[i][j+1]);
            }
        
        return dp[0][0];
      
    }
}