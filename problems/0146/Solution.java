class LRUCache {
    
    private Map<Integer, Integer> keyVal = new HashMap<>();
    private Map<Integer, Integer> keyPriority = new HashMap<>();
    private Map<Integer, Integer> priorityKey = new HashMap<>();
    int maxCapacity;
    int totItems;
    int currentPriority;
    public LRUCache(int c) {
        maxCapacity = c;
        totItems = 0;
        currentPriority = Integer.MIN_VALUE;
    }
    
    public int get(int key) {
        if(!keyVal.containsKey(key)) return -1;
        
        int priority = keyPriority.get(key);
        currentPriority++;
        keyPriority.replace(key,currentPriority);
        
        priorityKey.remove(priority);
        priorityKey.put(currentPriority, key);
        
        return keyVal.get(key);
    }
    
    public void put(int key, int value) {
        if(keyVal.containsKey(key)){
            keyVal.replace(key,value);
            int priority = keyPriority.get(key);
            currentPriority++;
            keyPriority.replace(key, currentPriority);
            priorityKey.remove(priority);
            priorityKey.put(currentPriority, key);
            
        } else if(totItems < maxCapacity){
            keyVal.put(key,value);
            currentPriority++;
            keyPriority.put(key, currentPriority);
            priorityKey.put(currentPriority, key);
            totItems++;
        } else {
            Map.Entry<Integer, Integer> min = null;
            for(Map.Entry<Integer, Integer> e : priorityKey.entrySet()){
                if(min == null || min.getKey() > e.getKey()){
                    min = e;
                }
            }
            int minPriority = min.getKey();
            int k = priorityKey.get(minPriority);
            currentPriority++;
            
            keyVal.remove(k);
            keyVal.put(key, value);
            
            keyPriority.remove(k);
            keyPriority.put(key, currentPriority);
            
            priorityKey.remove(minPriority);
            priorityKey.put(currentPriority, key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */