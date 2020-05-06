class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int M = grid.length;
        int N = grid[0].length;
        
        if(grid[0][0] == 1)
            return 0;        
        
        int[][] dp = new int[M+1][N+1];
        dp[1][1] = 1;
        
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                if(i == 1 && j == 1) continue;
                
                if(grid[i-1][j-1] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[M][N];
    }
}