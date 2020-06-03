class Solution {
    public int numDistinct(String s, String t) {
        if(s == null || t == null) return 0;
        
        int sLen = s.length(), tLen = t.length();
       
        int[] dp = new int[tLen+1];
        dp[tLen] = 1;
        
        for(int i = sLen-1; i >= 0; i--){
            int prev = 1;
            for(int j = tLen-1; j >= 0; j--){
                int oldVal = dp[j];
                dp[j] += (s.charAt(i) == t.charAt(j) ? prev : 0);
                prev = oldVal;
            }
        }
        
        return dp[0];
    }
}