class Solution {
    public int kEmptySlots(int[] bulbs, int K) {
        TreeMap<Integer, Integer> active = new TreeMap<>();
        
        for(int i = 0; i < bulbs.length; i++){
            Integer left = active.floorKey(bulbs[i]);
            if(left != null && bulbs[i] - K - 1 == left)
                return i+1;
            Integer right = active.ceilingKey(bulbs[i]);
            if(right != null && right - K - 1 == bulbs[i])
                return i+1;   
            active.put(bulbs[i], i);
        }        
        return -1;
    }
}