class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    
    public int numTrees(int n) {

        if(memo.containsKey(n))
            return memo.get(n);
        
        if(n <= 1) return 1;
        int[][] dp = new int[n][n];
     
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += numTrees(i - 1) * numTrees(n-i);
        }
        memo.put(n, sum);
        return sum;
    }
}