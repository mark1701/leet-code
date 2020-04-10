class Solution {
    public void nextPermutation(int[] nums) {
        for(int i = nums.length -1; i > 0; i--){ 
            if(nums[i-1] < nums[i]){
                int j = nums.length - 1;
                while(j >= 0 && nums[j] <= nums[i-1])
                    j--;
                
                swap(nums,i-1,j);
                reverse(nums, i);
                return;
            }                
        }
        Arrays.sort(nums);
    }
    
    private void reverse(int[] nums, int idx){
        int i = idx, j = nums.length -1;
        while (i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] =  temp;
    }
}