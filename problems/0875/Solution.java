class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        
        int max = Integer.MIN_VALUE;
        for(int n : piles) max = Math.max(max, n);
        
        int hi = max;
        int lo = 1;
        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(canEat(piles, H, mid))
                hi = mid;
            else 
                lo = mid + 1;
        }
        
        return lo;
    }
    
    private boolean canEat(int[] piles, int H, int K){
        int N = piles.length;
        
        int i = 0;
        int rem = piles[0];
        while(i < N && H > 0){
            int hours = (piles[i]+K-1)/K;
            H -= hours;
            i++;
        }
        
        return (i == N && H >= 0);
    }
}