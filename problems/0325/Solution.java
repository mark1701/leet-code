class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        
        int N = nums.length;
       
        int[] prefixSum = new int[N];
        prefixSum[0] = nums[0];
        for(int i = 1; i < N; i++)
            prefixSum[i] = prefixSum[i-1]+nums[i];
        
        //sum(i, j) = prefixSum[j] - prefixSum[i-1]
        // we only want sum(i, j) that are k
        // k = prefixSum[j] - prefixSum[i-1]
        //            |            |
        //            V            V
        //     this is curr    we only care if such an element exists so we store them in a hashtable
        
        //k = prefixSum[j] - prefixSum[i-1] ==> k - prefixSum[j] = - target ==> prefixSum[j] - k = traget
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1); //this represent the beginning of the array and it has index - 1
        /*map.put(0,-1) is just to say if the nums[i]-k==0 which means index from 0 to index i will make to sum k.
in this case, the length of the subarray will be 0,1,2,...i, which is i+1, so you need the value of map.get(nums[i]-k) to be "-1"*/
        
        int maxLen = 0;
        for(int j = 0; j < N; j++){
            if(map.containsKey(prefixSum[j] - k))
                maxLen = Math.max(maxLen, (j - map.get(prefixSum[j] - k)));
            if(!map.containsKey(prefixSum[j]))
                map.put(prefixSum[j],j);
        }
        return maxLen;
        
    }
}