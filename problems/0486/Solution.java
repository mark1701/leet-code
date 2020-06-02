class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int N = nums.length;
        
        int[][] memo = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                memo[i][j] = -1;
            
        
        return predict(nums, 0, N-1, memo) >= 0;
    }
    
    private int predict(int[] nums, int l, int r, int[][] memo){
        
        if(l==r) return nums[l];
        if(memo[l][r] > -1) return memo[l][r];
        int takeL = nums[l] - predict(nums, l+1, r, memo);
        int takeR = nums[r] - predict(nums, l, r-1, memo);
        memo[l][r] = Math.max(takeL, takeR);
        return memo[l][r];
            
    }
}