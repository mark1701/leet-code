class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        
        int maxSize = 0;
        while(end < s.length()){
            
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c,0)+1);
            end++;
            
            while(map.size() > 2){
                c = s.charAt(start);
                start++;
                int occurrences = map.get(c);
                occurrences--;
                if(occurrences == 0)
                    map.remove(c);
                else
                    map.put(c,occurrences);                
            }
                
            maxSize = Math.max(maxSize, end - start);
        }
        
        return maxSize;
    }
}