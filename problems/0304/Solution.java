class NumMatrix {
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        if(matrix == null) return;

        if(matrix.length == 0 || matrix[0].length == 0) return;
        int M = matrix.length;
        int N = matrix[0].length;
        dp = new int[M+1][N+1];
        
        for(int i = 1; i <= M; i++)
            for(int j = 1; j <= N; j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i-1][j-1];              
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(dp == null) return 0;
        row1++;
        col1++;
        row2++;
        col2++;
        
        int sum = dp[row2][col2];
        sum -= dp[row1-1][col2];
        sum -= dp[row2][col1-1];
        sum += dp[row1-1][col1-1];
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */