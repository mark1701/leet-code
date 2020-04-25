class Solution {
    public int countSubstrings(String s) {
        int N = s.length();
        
        if(N == 0) return 0;
        
        boolean[][] dp = new boolean[N+1][N];

        int count = 0;
        for(int i = N-1; i >= 0; i--){
            for(int j = i; j < N; j++){
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && ((j-i+1<3) || dp[i+1][j-1] );
                if(dp[i][j]) count++;
            }
        }      
        
        return count;
    }
   
}