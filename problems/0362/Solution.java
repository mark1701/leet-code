class HitCounter {
    private Deque<Item> queue;
    private final int TimeLimit = 300;
    private int count;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList<>();
        count = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        
        if(!queue.isEmpty() && queue.getFirst().time == timestamp)
            queue.getFirst().count++;
        else
            queue.add(new Item(timestamp)); 
                      
        count++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int valid = timestamp - TimeLimit;
        
        while(!queue.isEmpty() && queue.peek().time <= valid)            
            count -= queue.poll().count;
        
        return count;
    }
    
    private class Item{
        int time;
        int count;
        
        public Item(int t){
            time = t;
            count = 1;
        }
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */