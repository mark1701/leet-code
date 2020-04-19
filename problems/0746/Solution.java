class Solution {
    
    
    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;
        
        int[] dp = new int[N+2];
        dp[0] = 0;
        dp[1] = 0;
        
        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-2]);
        }
        
        return Math.min(dp[dp.length-1], dp[dp.length-2]);        
    }    
}