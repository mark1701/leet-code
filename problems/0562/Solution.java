class Solution {
    int max = 0;
    private final int H = 0;
    private final int V = 1;
    private final int Dp = 2;
    private final int Dm = 3;
    public int longestLine(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int[][][] dp = new int[matrix.length+1][matrix[0].length+2][4];
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length-1; j++){
                if(matrix[i-1][j-1] == 0) continue;
                
                dp[i][j][H] = dp[i][j-1][H] + 1;
                dp[i][j][V] = dp[i-1][j][V] + 1;
                dp[i][j][Dp] = dp[i-1][j-1][Dp] + 1;
                dp[i][j][Dm] = dp[i-1][j+1][Dm] + 1;
                max = Math.max(max, dp[i][j][H]);
                max = Math.max(max, dp[i][j][V]);
                max = Math.max(max, dp[i][j][Dp]);
                max = Math.max(max, dp[i][j][Dm]);
            }
        }
        return max;
    }
}