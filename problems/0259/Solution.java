class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        if(nums == null || nums.length == 0)
            return count;
        int N = nums.length;
        
        Arrays.sort(nums);
        
        // a + b < t - c         
        for(int i = 0; i < N - 2; i++)
            count += twoSum(nums, target - nums[i], i+1);
        
        return count;
    }
    
    private int twoSum(int[] nums, int t, int idx){
        int count = 0;
        int N = nums.length;
        
        //a + b < t
        // a < t - b
        for(int i = idx; i < N - 1; i++){           
            int j = binarySearch(nums, t - nums[i], i);
            
            count += j - i;            
        }
        return count;
    }
    
    private int binarySearch(int[] nums, int t, int idx){
        int lo = idx;
        int hi = nums.length - 1;
        
        while(lo < hi){
            int mid = lo + (hi - lo+1) / 2;
            if(nums[mid] < t)
                lo = mid;
            else 
                hi = mid- 1;
        }
        return lo;
    }
}