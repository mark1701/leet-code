class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1,-1};
        
        int idxOfSmaller = binarySearchSmaller(nums, target); //index of biggest element smaller than target
        int idxOfBigger = binarySearchBigger(nums, target); //index of smallest element bigger than target
        
        int left = findLowerBound(nums, idxOfSmaller, target);
        int right = findUpperBound(nums, idxOfBigger, target);
        
        int[] res = new int[] {-1,-1};
        if(left != -1 && right != -1){
            res[0] = left;
            res[1] = right;
        }
        return res;
    }
    
    
    private int binarySearchSmaller(int[] nums, int target){
        
        int lo = 0, hi = nums.length -1;
        //index of biggest element smaller than target
        // 0 1 2 3 4 5
        // 5 7 7 8 8 10
        
        while(lo < hi){
            int mid = lo + (hi-lo+1)/2;
            if(nums[mid] >= target){
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;        
    }
    
    private int binarySearchBigger(int[] nums, int target){
        
        int lo = 0, hi = nums.length -1;
        // 0 1 2 3 4 5
        // 5 7 7 8 8 10
        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] > target){
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return lo;        
    }
        
    private int findLowerBound(int[] nums, int idx, int target){
        if(nums[idx] == target) return idx;        
        if(idx < nums.length - 1 && nums[idx+1] == target) return idx+1;
        return -1;        
    }
    
    private int findUpperBound(int[] nums, int idx, int target){
        if(nums[idx] == target) return idx;
        if(idx > 0 && nums[idx-1] == target) return idx-1;
        return -1;        
    }
}