class Solution {
    public boolean isPossible(int[] nums) {
        
        Map<Integer, Integer> hm = new HashMap<>();        
        Map<Integer, Integer> fm = getFrequencies(nums);            
        
        for(int x : nums){
            
            //if there's nothing to do with this number... skip
            if(fm.get(x) == 0) continue;
            
            //try to expand existing sequence first
            if(hm.containsKey(x) && hm.get(x) > 0){
                hm.put(x, hm.get(x)-1);
                hm.put(x+1, hm.getOrDefault(x+1, 0) + 1);
                fm.put(x, fm.get(x)-1);
                continue;
            }
            
            //no alternative, we need to start a new sequence
            Integer y = x + 1;
            Integer z = x + 2;
            
            //check if we have what we need in order to start a new sequence
            if(fm.get(y) == null || fm.get(y) == 0) return false;
            if(fm.get(z) == null || fm.get(z) == 0) return false;
            
            //if we are here we have what we need so update the frequencies
            fm.put(x, fm.get(x)-1);
            fm.put(y, fm.get(y)-1);
            fm.put(z, fm.get(z)-1);
            hm.put(z+1, hm.getOrDefault(z+1,0)+1);
        }
        
        return true;   
    }
      
    private Map<Integer, Integer> getFrequencies(int[] nums){
        Map<Integer, Integer> fm = new HashMap<>();
        for(int i : nums)
            fm.put(i, fm.getOrDefault(i,0)+1);
        return fm;
    }
}