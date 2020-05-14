class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2) { // If the given k is no less than this value, i.e., k >= n/2, we can extend k to positive infinity
            int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

            for (int price : prices) {
                int T_ik0_old = T_ik0;
                T_ik0 = Math.max(T_ik0, T_ik1 + price);
                T_ik1 = Math.max(T_ik1, T_ik0_old - price);
            }
        
            return T_ik0;
        }
        
        int N = prices.length;
        int[] T0 = new int[k+1];
        int[] T1 = new int[k+1];
        
        Arrays.fill(T1, Integer.MIN_VALUE);
            
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= k; j++){
                T0[j] = Math.max(T0[j],T1[j]+prices[i-1]);
                T1[j] = Math.max(T1[j],T0[j-1]-prices[i-1]);
            }
        }
        
        return T0[k];
    }
}