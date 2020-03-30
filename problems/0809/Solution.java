class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int count = 0;
        for(String w : words)
            if(check(s, w)) count++;
        return count;
        
    }
    
    private boolean check(String s, String w){
        
        int i = 0;
        int j = 0;
        
        while(i < s.length() && j < w.length()){
            if(s.charAt(i) != w.charAt(j)) return false;
            
            int countS = 1;            
            while(i + 1 < s.length() && s.charAt(i+1) == s.charAt(i)){
                i++; 
                countS++;
            }
            
            int countW = 1;
            while(j + 1 < w.length() && w.charAt(j+1) == w.charAt(j)){
                j++; 
                countW++;
            }
            
            if(countS < countW) return false;
            if(countS > countW && countS < 3) return false;
            i++;
            j++;
        }

        if(!(i >= s.length() && j >= w.length())) return false;
        return true;
    }
}