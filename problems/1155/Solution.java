class Solution {
    public int numRollsToTarget(int dice, int f, int target) {
        
        int MOD = 1000000007;
        
        //state = number of ways to generate target t with d dice
        //  example with d = 2; f = 6; t = 7
        //         * * * * * *   // faces
        //         v v v v v v
        //       0 1 2 3 4 5 6 7 //target
        //    0  1 0 0 0 0 0 0 0
        //    1  0 1 1 1 1 1 1 0
        //    2  0 0 1 2 3 4 5 6
        //    ^
        //   die
        
        int[][] dp = new int[dice+1][target+1];
        dp[0][0] = 1;
        
        for(int d = 1; d <= dice; d++)
            for(int t = 1; t <= target; t++){                
                if(t > d * f) break;
                
                //pick the faces smaller or equal to the target
                for(int k = 1; k <= f && k <= t; k++)
                    dp[d][t] = (dp[d][t] + dp[d-1][t-k]) % MOD;
                    //d[d-1][t-k] what does it mean? -> imagine of removing of of the previous rolls, 
                    //you remove 1 die (d-1) and the target becomes the target minus the face used that time (t-k)
            }
        
        return dp[dice][target];
    }
}