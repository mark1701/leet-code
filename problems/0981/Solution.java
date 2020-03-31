class TimeMap {

    Map<String, List<Data>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Data> items = map.get(key);
        
        if(items == null){ //first time
            items = new ArrayList<>();
            items.add(new Data(value, timestamp));
            map.put(key, items);
        } else{ //already present
            items.add(new Data(value, timestamp));            
        }
    }
    
    public String get(String key, int timestamp) {
        List<Data> items = map.get(key);
        if(items == null) return "";
        
        return findMRB(items, timestamp);
    }    
    
    private String findMRB(List<Data> items, int timestamp){
        
        int lo = 0;
        int hi = items.size() - 1;
        
        while(lo < hi){        
            int mid = lo +(hi-lo+1)/2;
            Data data = items.get(mid);
            if(data.time <= timestamp)
                lo = mid;
            else
                hi = mid - 1;            
        }
        
        Data data = items.get(lo);
        if(data.time > timestamp) return "";
        return data.value;        
    }
    
    
    private class Data{
        
        String value;
        int time;
        
        public Data(String v, int t){
            value = v;
            time = t;
        }
        
        public int compareTo(Data that){
            return this.time - that.time;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */