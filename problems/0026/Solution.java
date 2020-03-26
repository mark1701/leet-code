class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int i = 0;
        int writer = 0;
        while (i < nums.length && writer < nums.length){
            nums[writer] = nums[i];
            writer++;
            int element = nums[i];
            i++;
            while(i < nums.length && nums[i] == element) i++;
        }
        return writer;
    }
}