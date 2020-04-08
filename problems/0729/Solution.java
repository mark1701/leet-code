class MyCalendar {

   Set<Interval> calendar;
    
    public MyCalendar() {
        calendar = new HashSet<>();
    }
    
    public boolean book(int start, int end) {
        Interval intr = new Interval(start, end);
        for(Interval i : calendar){
            if(!(intr.start >= i.end || intr.end <= i.start)){
                return false;
            }

        }
        calendar.add(intr);
        return true;
    }
    
    private class Interval {
        
        int start;
        int end;
        
        public Interval(int start, int end){
            this.start = start;
            this.end = end;            
        }
        
        @Override
        public boolean equals(Object o){
            if(o == this) return true;
            
            if(!(o instanceof Interval)) return false;
            
            Interval intr = (Interval) o;
            
            return this.start == intr.start && this.end == intr.end;
        }
        
        @Override
        public int hashCode(){
            int hc = 17;
            hc = hc + 31 * Integer.hashCode(start);
            hc = hc + 31 * Integer.hashCode(end);
            return hc;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */