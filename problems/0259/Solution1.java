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

        int start = idx;
        int end = nums.length - 1;
        
        while (start < end){
            if(nums[start] + nums[end] >= t)
                end--;
            else{
                count += end - start;
                start++;
            }   
        }
        return count;
    }
}