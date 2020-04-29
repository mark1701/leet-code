class Solution {
    
    public int numDecodings(String s) {  
        
        int N = s.length();
        
        int[] dp = new int[N+1];
        
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        
        for(int i = 2; i < N+1; i++){
            if(s.charAt(i-2) != '0' && Integer.parseInt(s.substring(i-2, i+1)) <= 26)
                dp[i] = dp[i-2];
            if(s.charAt(i-1) != '0')
                dp[i] += dp[i-1];            
        }
        return dp[N];
    }
    
    /*
    Alternatively, the following sol was copied from the forum
     public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
    
    */
    
  
}