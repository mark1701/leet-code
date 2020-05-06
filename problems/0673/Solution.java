class Solution {
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        
        int[] longest = new int[N];       
        int[] count = new int[N];
        Arrays.fill(count,1);
        
        for(int j = 0; j < N; j++){
            for(int i = 0; i < j; i++){
                if(nums[i] < nums[j]){
                    if(longest[i] >= longest[j]){
                        longest[j] = longest[i]+1;
                        count[j] = count[i];
                    }else if(longest[i]+1 == longest[j]){
                        count[j] += count[i];
                    }
                }
            }
        }
        
        int maxLen = 0;
        for (int l : longest)
            maxLen = Math.max(maxLen, l);
        
        int res = 0;
        for(int i = 0; i < N; i++)
            if(longest[i] == maxLen)
                res += count[i];
            
        return res;
    }
}