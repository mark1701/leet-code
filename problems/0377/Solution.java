class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;

        int[] memo = new int[target+1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        
        compute(nums, target, memo);
        return memo[target];
    }
    
    private int compute(int[] nums, int target, int[] memo){                
        if(memo[target] >= 0) return memo[target];
        
        int count = 0;
        for(int n : nums)
            if(target >= n)
                count += compute(nums, target - n, memo);            
        
        memo[target] = count;
        return count;
    }
}