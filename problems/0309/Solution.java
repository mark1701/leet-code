class Solution {
    public int maxProfit(int[] prices) {
    int T0_pre = 0, T0 = 0, T1 = Integer.MIN_VALUE;
    
    for (int price : prices) {
        int T0_old = T0;
        T0 = Math.max(T0, T1 + price);
        T1 = Math.max(T1, T0_pre - price);
        T0_pre = T0_old;
    }
    
    return T0;
}
}