class Solution {
    
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        
        int maxLen = 1;
        int start = 0;
        int end = 0;
        
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        
        for(int i = 0; i < N; i++)
            dp[i][i] = true;

        for(int i = 0; i < N - 1; i++){
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
            dp[i+1][i] = dp[i][i+1];
            if(dp[i][i+1] && 2 > maxLen){
                    maxLen = 2;
                    start = i;
                    end = i+1;                    
                }
        }
        
        for(int i = N-2; i >= 0; i--){
            for(int j = i + 2; j < N; j++){
                dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                if(dp[i][j] && (j - i + 1) > maxLen){
                    maxLen = j - i + 1;
                    start = i;
                    end = j;                    
                }
            }
        }
        
        return s.substring(start, end+1);
    }
        
 }
