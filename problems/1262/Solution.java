class Solution {
   public int maxSumDivThree(int[] nums) {
       int[] dp = new int[3];
       
       for(int n : nums){
            int[] next = dp.clone();           
            for(int sum : dp){
               int sumn = sum + n;
               int idx = sumn % 3;
               next[idx] = Math.max(next[idx], sumn);
           }
           dp = next;
       }
       
       return dp[0];
    }
}

