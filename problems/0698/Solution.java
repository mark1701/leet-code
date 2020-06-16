class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, max = Integer.MIN_VALUE;
        for(int n : nums){
            sum += n;
            max = Math.max(max, n);
        }
        if(sum % k != 0 || max > sum/k) return false;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        return dfs(nums, 0, nums.length-1, visited, sum/k, k);
    }
    
    private boolean dfs(int[] A, int sum, int st, boolean[] visited, int target, int round){
        if(round == 0) return true;
        
        if(sum == target){
            return dfs(A, 0, A.length-1, visited, target, round-1);
        }
        
        for(int i = st; i >= 0; --i){
            if(!visited[i] && sum + A[i] <= target){
                visited[i] = true;
                if(dfs(A, sum+A[i], i - 1, visited, target, round))
                    return true;            
                visited[i] = false;
            }
        }        
        return false;
    }               
}