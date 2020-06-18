class Solution {
    public int removeDuplicates(int[] nums) {
        int LIMIT = 2;
        
        if(nums == null || nums.length == 0) return 0;
        int N = nums.length;
        
        int write = 0, read = 0;
        int count = 0;
        while(read < N){
            if(count < LIMIT){
                nums[write++] = nums[read++];
                count++;
                if(read < N && nums[read] != nums[read-1]) count = 0;
                continue;
            }
            count = 0;
            while(read < N && nums[read] == nums[read-1]) read++;            
        }
        
        return write;
    }
}