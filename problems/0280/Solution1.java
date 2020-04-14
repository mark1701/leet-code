class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) return;
        
        int N = nums.length;
        
        boolean less = true;       
        for(int i = 0; i < N - 1; i++){
            if(less){
                if(nums[i] > nums[i+1])
                    swap(nums, i, i+1);
            }else{
                if(nums[i] < nums[i+1])
                    swap(nums, i, i+1);
            }
            less = !less;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}