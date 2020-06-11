class Solution {
   public int lastStoneWeightII(int[] stones) {
    int n = stones.length, sum = 0;
    for (int s : stones) sum += s;
    int[][] dp = new int[n + 1][sum / 2 + 1];
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= sum / 2; j++) {
            if (j >= stones[i - 1]) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    return sum - 2 * dp[n][sum / 2];
}
}