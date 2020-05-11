class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while(end < nums.length){
            sum += nums[end];
            while(sum >= s){
                minLen = Math.min(minLen, end-start+1);
                sum -= nums[start++];
            }
            end++;
        }
        return minLen < Integer.MAX_VALUE ? minLen : 0;
    }
}