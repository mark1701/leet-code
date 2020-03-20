class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;
        
        int i = 0;
        int j= 0;
        while(i < nums.length){
            
            if(nums[i] != 0) { 
                i++;
                continue;
            }
            
            while(j <= i || (j < nums.length && nums[j] == 0)) j++;
            if(j >= nums.length) break;
           
            nums[i] = nums[j];
            nums[j] = 0;
                       
            i++;            
        }
        
        return;
    }
}