class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        
        int N = arr.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        
        int max = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(arr[i]-arr[j] == diff)
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = Math.max(max, dp[i]);
        }
        
        return max; 
    }
}