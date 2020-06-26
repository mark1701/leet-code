class Solution {
    public int maxScore(int[] nums, int k) {
        int N = nums.length;
        
        int total = 0;
        for(int n : nums) total += n;
        
        int curr = 0;
        for(int i = 0; i < N-k; i++) curr += nums[i];
        
        int max = total-curr;
        if(max == total) return max;
        
        int start = 0, end = N-k;
        while(end < nums.length) {
            curr = curr - nums[start] + nums[end];
            max = Math.max(max, total-curr);
            start++; end++;
        }
        return max;
    }
}