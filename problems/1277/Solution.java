class Solution {
    public int countSquares(int[][] matrix) {
        int N  = matrix.length;
        int M = matrix[0].length;
        
        int[][] dp = new int[N][M];
        
        int L = Math.min(N,M);
        for(int l = 1; l <= L; l++){
            
            for(int i = N-1; i-l+1 >= 0; i--){
                for(int j = M-1; j-l+1 >=0; j--){
                    
                     
                    if(l == 1) dp[i][j] = matrix[i][j];
                    else if(i> 0 && j > 0 && dp[i][j] > 0 && dp[i][j] == dp[i-1][j] && dp[i][j] == dp[i-1][j-1] && dp[i][j] == dp[i][j-1]){
                           System.out.println("l: " + l);
                        System.out.println("i,j: " + i + "," + j);
                        dp[i][j] = dp[i][j] + 1;
                        System.out.println(dp[i][j]);
                    }
                }
            }
        } 
        
        int sum = 0;
        for(int i = N-1; i >= 0; i--)
                for(int j = M-1; j >=0; j--)
                    sum+= dp[i][j];
        
        return sum;
    }
}