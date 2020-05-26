class Solution {
    public int splitArray(int[] nums, int m) {
       
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int n : nums){
            sum += n;
            min = Math.min(min, n);
        }
        if(sum < 0) return Integer.MAX_VALUE;
        
        int lo = min, hi = sum;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(split(nums, m, mid)){
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return lo;    
    }

     private boolean split(int[] nums, int m, int target){        
        int count = 0;
        int sum = 0;
        for(int n : nums){
            sum+=n;
            if(n > target) return false;
            if(sum > target){
                sum = n;
                count++;
            }
            if(count > m) break;
        }
        
        if(count > m) 
            return false;
        if(count < m)
             return true;
        return sum == 0;
    }
}