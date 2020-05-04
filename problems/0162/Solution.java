public class Solution {
    public int findPeakElement(int[] nums) {
        
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            
            //   /\
            //  /  \
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid+1 == nums.length || nums[mid] > nums[mid+1])) return mid;

            //  /
            // /
            if((mid == 0 || nums[mid] > nums[mid-1]) && mid+1 < nums.length && nums[mid] < nums[mid+1]){
                left = mid+1;
            }else{
                // \
                //  \
                right = mid;
            }
            
            // the following case doesn't matter, I can pick either left or right and it will be ok
            // \  /
            //  \/
        }
        return left;
    }
 
}