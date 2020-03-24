class Solution {
    public int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length == 0) return 0;
        
        int N = nums.length;
        
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int maxLen = 1;
        for(int i = 0; i < N; i++)
            if(dp[i] > maxLen)
                maxLen = dp[i];
        
        return maxLen; 
    }  
}