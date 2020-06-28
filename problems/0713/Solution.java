class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k < 1) return 0;
        
        int N = nums.length;
        
        int res = 0;
        int prod = 1;
        int start = 0;
        for(int i = 0; i < N; i++){
            prod *= nums[i];
            while(start < N && prod >= k) prod /= nums[start++];
            if(prod < k){
                res += i - start + 1;
            }
        }
        return res;
    }
}