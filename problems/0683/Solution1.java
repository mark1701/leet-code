class Solution {
    public int kEmptySlots(int[] bulbs, int K) {
        int[] days = new int[bulbs.length+1];
        
        for(int i = 0; i < bulbs.length; i++){
            days[bulbs[i]] = i+1; 
        }
        
        int min = Integer.MAX_VALUE;
        int left = 1;
        int right = K + 2;
        for(int i = 2; right < days.length; i++){
            if(i == right){
                min = Math.min(min, Math.max(days[left], days[right]));
                left = i;
                right = left + K + 1;
            }
            if(days[i] > days[left] && days[i] > days[right])
                continue;            
            left = i;
            right = left + K + 1;            
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}