class Solution {
    //ac 2[abc] 3[ 3[a 2[c] ] ] ef
    public String decodeString(String s) {
        if(s.length() == 0) return "";
        
        int start = 0;
        StringBuilder sb = new StringBuilder();
        
        //process front
        while(start < s.length() && Character.isLetter(s.charAt(start))){
            sb.append(s.charAt(start));
            start++;            
        }
        
        if(start < s.length()){ //this must be the beginning of a number
            int numberEnd = findNumberEnd(s, start); //find where the number ends
            int rep = Integer.parseInt(s.substring(start, numberEnd+1));
            start = numberEnd+1; //skip it, now this must be a [
            int end = findMatchingParentheses(s, start); //find the matching ]
            String inner = decodeString(s.substring(start+1, end));
            start = end+1;

            while(rep > 0){
                sb.append(inner);
                rep--;
            }            
        }
        
        if(start < s.length()){
            String tail = decodeString(s.substring(start));
            sb.append(tail);
        }
        
        return sb.toString();
    }
    
    private int findNumberEnd(String s, int start){
        int end = start;
        while(end < s.length() && s.charAt(end) <= 57)
            end++;
                
        return end-1;
    }
        
    private int findMatchingParentheses(String s, int start){
        int count = 0;
        while(start < s.length()){
            
            char c = s.charAt(start);
            if(c == '[')
                count++;
            else if (c == ']')
                count--;
            if(count == 0) break;
            start++;
        }
        return start;
    }
}