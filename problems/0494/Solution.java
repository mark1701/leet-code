class Solution {
    public int findTargetSumWays(int[] nums, int x) {
        // sum(P) - sum(N) = target
        // sum(P) + sum(N) = sum(nums)
        
        // sum(nums) -sum(P) = sum(N)
        // sum(P) = target + sum(N)
        
        //sum(P) = target + sum(nums) - sum(P)
        //sum(P) = (target + sum(nums))/2
        //int x = (target + sum(nums))/2
        
        int sum = 0;
        for(int num : nums)
            sum += num;
        
        if(x > sum) return 0;
        
        int target = x + sum;
        if(target % 2 != 0)
            return 0;        
        target /= 2;
        
        int N = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;        
        
        for(int num : nums){
            for(int j = target; j >= 0; j--){
                if(j >= num){
                    dp[j] += dp[j - num];
                }
            }
        }
        return dp[target];
    }
}