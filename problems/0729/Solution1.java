class MyCalendar {

   TreeMap<Integer, Integer> calendar;
    
    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer floor = calendar.floorKey(start);
        if(floor != null && calendar.get(floor) > start) return false;
        
        Integer ceiling = calendar.ceilingKey(start);
        if(ceiling != null && ceiling < end) return false;
        
        calendar.put(start, end);
        return true;
    }
    
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */