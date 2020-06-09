class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
               
        int N = nums.length;
        
        int lo = 0, hi = N-1;
        
        while(lo < hi){
            int mid  = lo + (hi-lo)/2;
            if(nums[hi] < nums[mid]){
                lo = mid+1;
            } else{
                hi = mid;
            }
        }
        
        return nums[lo];
    }
}