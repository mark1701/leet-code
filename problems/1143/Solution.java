class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int N = s1.length();
        int M = s2.length();
        
        int[][] dp = new int[N+1][M+1];
        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < M+1; j++){
                if(i == 0 || j == 0) continue;
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[N][M];
    }
}