class MyCalendarTwo {

    List<Event> singleB;
    List<Event> doubleB;
    
    public MyCalendarTwo() {
        singleB = new ArrayList<>();
        doubleB = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        Event event = new Event(start, end);
        
        for(Event e : doubleB)
            if(event.conflicts(e)) return false;
        
        for(Event e : singleB)
            if(event.conflicts(e))
                doubleB.add(intersect(event, e));

        singleB.add(event);
        
        return true;
    }
    
    private Event intersect(Event a, Event b){
        int start = Math.max(a.start, b.start);
        int end = Math.min(a.end, b.end);
        return new Event(start, end);
    }
    
    private class Event{
        
        int start;
        int end;
        
        public Event(int s, int e){
            start = s;
            end = e;
        }
        
        public boolean conflicts(Event that){
            if(that.end <= this.start || that.start >= this.end)
                return false;
            return true;
        }
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */