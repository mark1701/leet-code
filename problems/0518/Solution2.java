class Solution {    
    public int change(int M, int[] coins) {        
        int[] dp = new int[M+1];
        dp[0] = 1;
        
        for(int i = 1; i <= coins.length; i++)               
            for(int j = coins[i-1]; j <= M; j++)                
                dp[j] += dp[j-coins[i-1]];                    
                
        return dp[M];
    }
}