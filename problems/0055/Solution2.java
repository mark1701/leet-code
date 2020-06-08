class Solution {
    public boolean canJump(int[] nums) {
        int N = nums.length;

        int last = N-1;
        for(int i = N-1; i >= 0; i--){
            if(nums[i] + i >= last)
                last = i;
        }
        return last == 0;
    }
}