class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int N = nums.length;
        int[] dp = new int[N];
        
        int len = 0;
        for(int i = 0; i < N; i++){
            if(len == 0) {
                len++;
                dp[len-1] = nums[i];
                continue;
            }
            
            int pos = Arrays.binarySearch(dp, 0 , len, nums[i]);
            if(pos >= 0) continue;
            int ip = -pos - 1;
            
            
            if(ip == len){
                //everything is smaller, need to create a new pile
                len++;
            }
            dp[ip] = nums[i];
            
        }
        return len;
    }
}