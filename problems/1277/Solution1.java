class Solution {
    public int countSquares(int[][] matrix) {
        int N  = matrix.length;
        int M = matrix[0].length;
        
        int[][] dp = new int[N+1][M+1];
        
        int sum = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(matrix[i-1][j-1] == 1){
                    int min = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
                    dp[i][j] = min + 1;
                    sum += dp[i][j];
                }
            }
        }
        
        return sum;
        
    }
}