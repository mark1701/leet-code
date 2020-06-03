class Solution {
    
    public int change(int M, int[] coins) {
        
        int N = coins.length;
        int[][] dp = new int[N+1][M+1];
        dp[0][0] = 1;
            for(int i = 1; i <= N; i++){    
                dp[i][0] = 1;
                for(int j = 1; j <= M; j++){
                    dp[i][j] = dp[i-1][j];
                    int coin = coins[i-1];
                    if(j >= coin) dp[i][j] += dp[i][j-coin];
                }
            }
                
        return dp[N][M];
    }
    
}