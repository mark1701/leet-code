class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int N = nums.length;
        int[] pre = new int[N];
        pre[0] = nums[0];
        for(int i = 1; i < N; i++)
            pre[i] = pre[i-1]+nums[i];
        
        //-1 2 1 0 3
        //-1 1 2 2 5
            
        int count = 0;
        for(int i = 0; i < N; i++){
            if(pre[i] == k) count++;
            for(int j = 0; j < i; j++){
                if(pre[i] - pre[j] == k) count++;
            }
        }
        
        return count;
    }
}