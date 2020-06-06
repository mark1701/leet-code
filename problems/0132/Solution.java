class Solution {
    public int minCut(String s) {
        if(s == null || s.length() <= 1) return 0;
        int N = s.length();
        
        int[] dp = new int[N];
        for(int i = 1; i < N; i++) dp[i] = i;
        
        for(int center = 0; center < N; center++){
            findCut(s, center, center, dp);
            findCut(s, center, center+1, dp);
        }
        return dp[N-1];
    }
    
    private void findCut(String s, int l, int r, int[] dp){
        
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            if(l == 0)
                dp[r] = 0;
            else
                dp[r] = Math.min(dp[r], dp[l-1]+1);
            l--;
            r++;
        }
    }
}