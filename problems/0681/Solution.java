class Solution {
    public String nextClosestTime(String time) {
        time = time.substring(0,2) + time.substring(3);
        Set<Integer> digits = getDigits(time);
        
        Set<String> allTimes = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        generateAllTimes(digits, sb, allTimes);
        
        Time input = new Time(time);
        Set<Time> tomorrow = new HashSet<>();
        Set<Time> today = new HashSet<>();
        
        for(String t : allTimes){
            Time curr = new Time(t);
            if(curr.compareTo(input) == 0) continue;
            if(curr.compareTo(input) < 0) tomorrow.add(curr);
            else today.add(curr);
        }
        
        Time min = null;
        if(!today.isEmpty())
            min = today.iterator().next();;
        
        for(Time t : today){
            if(t.compareTo(min) < 0)
                min = t;
        }
                
        if(min != null) return min.toString();
        
        if(tomorrow.isEmpty())
            return input.toString();
        
        min = tomorrow.iterator().next();
        for(Time t : tomorrow){
            if(t.compareTo(min) < 0)
                min = t;
        }
        
        return min.toString();
    }
    
    private void generateAllTimes(Set<Integer> digits, StringBuilder sb, Set<String> allTimes) {
        
        if(sb.length() == 4) {
            if(Integer.parseInt(sb.charAt(0) + "" + sb.charAt(1)) <= 23){
                if(Integer.parseInt(sb.charAt(2) + "" + sb.charAt(3)) <= 59)
                    allTimes.add(sb.toString());
            }
            return;
        }
        
        for(int i : digits){
            sb.append(i);
            generateAllTimes(digits, sb, allTimes);
            sb.deleteCharAt(sb.length()-1);            
        }        
    }
    
    private Set<Integer> getDigits(String time){
        Set<Integer> digits = new HashSet<>();
        for(int i = 0; i < 4; i++){
            char c = time.charAt(i);
            digits.add(Character.getNumericValue(c));
        }
        
        return digits;
    }
    
    class Time{
        String HH;
        String MM;
       
        public Time(String t){            
            HH = t.substring(0,2);
            MM = t.substring(2);
        }
        
        public int compareTo(Time that){
            
            if(!this.HH.equals(that.HH)) 
                return Integer.parseInt(this.HH) - Integer.parseInt(that.HH);
            
            if(! this.MM.equals(that.MM))                
                return Integer.parseInt(this.MM) - Integer.parseInt(that.MM);
            
            return 0;
        }
        
        @Override
        public String toString(){
            return HH + ":" + MM;
        }
    }
}