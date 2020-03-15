class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        for(int[] a: memo)
            Arrays.fill(a, -1);
        
        return lis(nums, -1, 0, memo);
    }
    
    private int lis(int[] nums, int prev, int pos, int[][] memo){
        
        if(pos >= nums.length){
            return 0;    
        }
        
        if(memo[prev+1][pos] != -1){
            return memo[prev+1][pos];
        }
            
        int t = 0;
        if(prev < 0 || nums[pos] > nums[prev]){
            t = 1 + lis(nums, pos, pos+1, memo);
        }
        
        int nt = lis(nums, prev, pos+1, memo);
        
        memo[prev+1][pos] = Math.max(t, nt); 
        return memo[prev+1][pos];        
    }
}