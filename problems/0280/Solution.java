class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) return;
        
        int N = nums.length;
        
        Arrays.sort(nums);
        
        for(int i = 1; i < N - 1; i++){
            if(i % 2 == 1)
                swap(nums, i, i+1);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}