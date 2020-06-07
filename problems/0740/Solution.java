class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int n : nums)
            count.put(n, count.getOrDefault(n, 0)+1);
        
        Arrays.sort(nums);
        int N = nums.length;
        int[] take = new int[N+1], notTake = new int[N+1];
        
        int prev = -1;
        
        for(int i = 1; i <= N; i++){
            if(!count.containsKey(nums[i-1])){
                take[i] = take[i-1];
                notTake[i] = notTake[i-1];
                continue;
            };
            int sum = nums[i-1]*count.get(nums[i-1]);
            int best = Math.max(take[i-1], notTake[i-1]);
            if(nums[i-1] == prev+1){
                take[i] = sum + notTake[i-1];                
            } else{
                take[i] = sum + best;
            }
            notTake[i] = best;
            count.remove(nums[i-1]);
            prev = nums[i-1];            
        }
        return Math.max(take[N], notTake[N]);
    }
    
}