class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        boolean oddUsed = false;
        int maxLen = 0;
        
        for(Character key : map.keySet()){
            int count = map.get(key);
            if(count % 2 == 0){
                maxLen += count;
                continue;
            }
            
            if(!oddUsed){
                maxLen += count;
                oddUsed = true;
            }else{
                maxLen += count - 1;
            }
            
        }
        
        return maxLen;
    }
}