class Solution {
    public int findMaxForm(String[] strs, int M, int N) {
        
        int L = strs.length;
        
        int[][][] dp = new int[L+1][M+1][N+1];
        for(int i = 1; i < L+1; i++){
            
            int[] count = countItems(strs[i-1]);
            
            for(int m = 0; m < M+1; m++){
                for(int n = 0; n < N+1; n++){                    
                    if(m >= count[0] && n >= count[1]){
                        dp[i][m][n] = Math.max(dp[i-1][m][n], dp[i-1][m-count[0]][n-count[1]]+1);
                    } else {
                        dp[i][m][n] = dp[i-1][m][n];
                    }
                }
            }
        }
        
        return dp[L][M][N];
    }
    
    private int[] countItems(String s){
        
        int[] count = new int[] {0,0};
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)-'0']++;
        }
        return count;
    }
}