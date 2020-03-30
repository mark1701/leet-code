class Solution {
    public int shipWithinDays(int[] weights, int D) {
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i = 0; i < weights.length; i++){
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }
        
        while(max <= sum){
            int mid = ((max + sum) / 2);
            
            if(canShip(weights, mid,D))
                sum = mid - 1;
            else
                max = mid + 1;
        }
        return max;
        
        
    }
    
    private boolean canShip(int[] weights, int capacity, int D){
        
        int start = 0;
        while(D > 0){

            int sum = 0;
            for(int i = start; i < weights.length; i++){
                if(sum + weights[i] <= capacity){
                    sum += weights[i];
                    start++;
                }else break;
            }
            D--;
        }
        return start >= weights.length;
    }
}