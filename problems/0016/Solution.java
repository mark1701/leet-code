class Solution {
    public int threeSumClosest(int[] nums, int target) {     
        int N = nums.length;
        if(N == 3) return nums[0]+nums[1]+nums[2];
        
        int res = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        
        for(int i = 0; i < N; i++){
            int sum = nums[i] + twoSumClosest(nums, i, target-nums[i]);
            int currDiff = Math.abs(target-sum); 
            if(currDiff < diff){
                diff = currDiff;
                res = sum;
            }
            if(res == target) break;
        }
        
        return res;
    }
    
    private int twoSumClosest(int[] nums, int skip, int target){
        
        int N = nums.length;
        
        int lo = 0, hi = N-1;
        int diff = Integer.MAX_VALUE;
        int res = 0;
        
        while(lo < hi){
            if(lo == skip) {
                lo++;
                continue;
            }
            if(hi == skip) {
                hi--;
                continue;
            }
            int sum = nums[lo] + nums[hi];
            if(sum == target) return target;
            else if(sum < target) lo++;
            else hi--;
            
            int currDiff = Math.abs(sum-target);
            if(currDiff < diff) {
                res = sum;
                diff = currDiff;
            }
            
            if(res == target) break;
        }
        return res;
    }
    
}