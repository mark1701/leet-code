class Solution {
    public int findMaxForm(String[] strs, int M, int N) {
        
        int L = strs.length;
        
        int[][] dp = new int[M+1][N+1];
        
        for(int i = 1; i < L+1; i++){            
            int[] count = countItems(strs[i-1]);
            
            for(int m = M; m >= 0; m--)
                for(int n = N; n >= 0; n--)                    
                    if(m >= count[0] && n >= count[1])
                        dp[m][n] = Math.max(dp[m][n], dp[m-count[0]][n-count[1]]+1);
                    
        }        
        return dp[M][N];
    }
    
    private int[] countItems(String s){
        
        int[] count = new int[] {0,0};
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)-'0']++;
        }
        return count;
    }
}