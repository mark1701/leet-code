class Solution {
    public int minFallingPathSum(int[][] grid) {
        
        int N = grid.length;
        if(N == 1) return grid[0][0];
        
        int[] dp1 = new int[N+2];
        int[] dp2 = new int[N+2];

        dp1[0] = dp1[N+1] = dp2[0] = dp2[N+1] = Integer.MAX_VALUE;
        
        for(int j = 1; j < N+1; j++)
            dp1[j] = grid[0][j-1];
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < N; i++){
            for(int j = 1; j < N+1; j++){
                dp2[j] = Math.min(dp1[j], Math.min(dp1[j-1], dp1[j+1])) + grid[i][j-1];                
                if(i == N-1){
                    min = Math.min(min, dp2[j]);
                }  
            }
            int[] tmp = dp2;
            dp2 = dp1;
            dp1 = tmp;
        }
        return min;        
    }
}