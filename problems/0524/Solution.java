class Solution {
    public String findLongestWord(String input, List<String> d) {
        String res = "";
        if(input == null || d == null) return res;
        
        // N = input.length();
        // M = d.size();
        // K = average length of a word in d
        
        for(String s : d){ //O(M)
            if(s.length() < res.length()) continue;
            if(true){
                boolean match = canBecome(input, s); //O(N)
                if(match){
                    if(s.length() > res.length() || s.compareTo(res) < 0)
                        res = s;                    
                }
            }
        }
        
        return res;
    }
    
    private boolean canBecome(String input, String s){
        
        int j = 0;
        for(int i = 0; i< s.length();){
            char c = s.charAt(i);
            while(j < input.length() && input.charAt(j) != c) 
                j++;
            if(j == input.length() && i < s.length()) return false;
           
            i++;
            j++;
        }
        return true;
    }
}