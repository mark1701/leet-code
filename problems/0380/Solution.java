class RandomizedSet {
    
    List<Integer> items;
    Map<Integer, Integer> map;
    Random rd;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        items = new ArrayList<>();
        map = new HashMap<>();
        rd = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        
        items.add(val);
        
        int position = items.size() - 1;
        map.put(val, position);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        int position = map.get(val);        
        
        int endVal = items.get(items.size()-1);
        
        items.set(position, endVal);
        items.remove(items.size()-1);
        
        map.remove(val);
        map.replace(endVal, position);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int position = rd.nextInt(items.size());
        return items.get(position);
    }
    

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */