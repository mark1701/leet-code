class Solution {
    public int maxProfit(int[] prices) {
       if(prices == null || prices.length ==0) return 0;
        int lo = prices[0], hi = prices[0];
        int max = 0;
       for(int i = 1; i < prices.length; i++){
           if(prices[i] < lo){
               lo = prices[i];
               hi = lo;
           } else if(prices[i] > hi){
               hi = prices[i];
               max = Math.max(max, hi-lo);
           }
       }
        
         return max;
    }
}