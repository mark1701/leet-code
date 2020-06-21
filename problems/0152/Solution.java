class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int N = nums.length;
        
        int left = nums[0], right = nums[N-1];
        
        int max = Math.max(left, right);
        
        for(int i = 1; i < N; i++){
            if(left == 0) left = nums[i];
            else left *= nums[i];
            if (right == 0) right = nums[N-1-i];
            else right *= nums[N-1-i];
            max = Math.max(max, Math.max(left, right));
        }
        return max;
    }
}