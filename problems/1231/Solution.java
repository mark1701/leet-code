class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
      
        if(sweetness == null || sweetness.length == 0) return 0;
        
        int sum = 0; 
        int min = Integer.MAX_VALUE;
        for(int s : sweetness){
            sum += s;
            min = Math.min(min, s);
        }
        
        int lo = min, hi = sum;
        
        while (lo < hi){
            int mid = lo + (hi-lo+1)/2;
               
            if(divide(sweetness, mid, K))
                lo = mid;
            else
                hi = mid -1;
        }
        
        return lo;
    }
    
    private boolean divide(int[] sweetness, int target, int K){        
        int sum = 0;
        for(int i : sweetness){
            sum += i;
            if(sum >= target){
                sum = 0;
                K--;
            }
        }
        return K < 0;
    }
}