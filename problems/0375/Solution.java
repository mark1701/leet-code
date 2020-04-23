class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return compute(dp,1,n);
    }
    
    private int compute(int[][] dp, int i, int j){
        if(i >= j) return 0;
        if(dp[i][j] > 0) return dp[i][j];
        int res = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++){
            int tmp = k + Math.max(compute(dp,i,k-1),compute(dp,k+1,j));
            res = Math.min(res, tmp);
        }
        dp[i][j] = res;
        return res;
    }
}