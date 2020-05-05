class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {    
        int M = triangle.size();
        int N = triangle.get(M-1).size();
        
        int[] dp = new int[N];
        
        for(int i = 0; i < N; i++)
            dp[i] = triangle.get(M-1).get(i);        
        
        for(int i = M-2; i >= 0; i--)
            for(int j = 0; j < triangle.get(i).size(); j++)
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
        
        return dp[0];
    }
}