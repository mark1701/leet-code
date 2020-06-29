class Solution {
    
    private double T = 1e-6;
    
    public double minmaxGasDist(int[] stations, int K) {
        
        double lo = 0, hi = findMaxDistance(stations);
        
        while(lo + T < hi){
            double mid = lo + (hi-lo)/2.0;
            if(canDivide(stations, mid, K)){
                hi = mid;
            } else {
                lo = mid + T;
            }
        }
        
        return lo;
    }
    
    
    private int findMaxDistance(int[] stations){
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < stations.length; i++){
            int dist = stations[i] - stations[i-1];
            max = Math.max(max, dist);
        }
        return max;
    }
    
    private boolean canDivide(int[] stations, double D, int K){
        
        for(int i = 1; i < stations.length; i++){
            double dist = stations[i] - stations[i-1];
            if(Math.abs(dist - D) > T) {
                int stationsNeeded = (int) (dist/D);
                if(stationsNeeded > K) return false;
                K -= stationsNeeded;
            }
        }
        
        return true;
    }
}