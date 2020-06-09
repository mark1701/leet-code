class Solution {
    public int longestArithSeqLength(int[] A) {
        int N = A.length;
        if(N == 2) return 2;
        
        Map<Integer,Integer>[] dp = new HashMap[N];
        int max = 2;
        
        for(int i = 0; i < N; i++){
            dp[i] = new HashMap<>();
            
            for(int j = 0; j < i; j++){
                int diff = A[i]-A[j];
                int len = 2;
                if(dp[j].containsKey(diff)){
                    len = dp[j].get(diff)+1;                    
                     max = Math.max(max, len);                    
                }
                dp[i].put(diff, Math.max(dp[i].getOrDefault(diff,0), len));
            }
        }
        return max;
    }
}