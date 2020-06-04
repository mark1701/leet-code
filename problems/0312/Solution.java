class Solution {
    public int maxCoins(int[] iNums) {
        
        int[] nums = new int[iNums.length+2];
        int N = 1;
        for(int n : iNums){
            if(n > 0) nums[N++] = n; 
        }
        
        int[][] memo = new int[N+1][N+1];
        nums[0] = nums[N++] = 1;
        return findSum(nums, 0, N-1, memo);
    }
    
    private int findSum(int[] nums, int l, int r, int[][] memo){
        if(l+1 == r) return 0;
        
        if(memo[l][r] > 0) return memo[l][r];

        int sum = 0;
        for(int i = l+1; i < r; i++){
            int currSum = nums[l] * nums[i] * nums[r];
            currSum += findSum(nums, l, i, memo) + findSum(nums, i, r, memo);
            sum = Math.max(sum, currSum);    
        }
        
        memo[l][r] = sum;
        return sum;
    }
}