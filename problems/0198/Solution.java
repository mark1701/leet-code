class Solution {
    public int rob(int[] value) {
        if(value == null || value.length == 0) return 0;
        
        int N = value.length;
        
        int[][] dp = new int[N][2];
        dp[0][0] = 0;
        dp[0][1] = value[0];
        
        for(int i = 1; i < N; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + value[i];
        }
        
        return Math.max(dp[N-1][0], dp[N-1][1]);
    }
}