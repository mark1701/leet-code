class Solution {
    public int coinChange(int[] coins, int amount) {
    
        Arrays.sort(coins); //O(m log m)

        int[] dp = new int[amount + 1]; 
        
        Arrays.fill(dp, Integer.MAX_VALUE); // ~O(n log n)
        dp[0] = 0; //base case
        
        for(int sum = 1; sum <= amount; sum++){ //O(n)
            for(int coin : coins){ //O(m)
                if(coin > sum) break;
                
                int val = sum - coin;
                if(dp[val] != Integer.MAX_VALUE){ 
                    dp[sum] = Math.min(dp[sum], dp[val] + 1);
                }
            }
        }
        
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
    
    //overall time complexity = O(n * m)
}