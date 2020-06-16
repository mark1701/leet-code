class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int N = nums.length;
        
        return Math.max(rob(nums,0,N-2), rob(nums,1,N-1));
    }
    
    private int rob(int[] nums, int start, int end){        
        int take = 0, notTake = 0;
        for(int i = start; i <= end; i++){
            int oldTake = take;
            take = notTake + nums[i];
            notTake = Math.max(notTake, oldTake);
        }
        return Math.max(take, notTake);
    }
}