class Solution {
    public int longestSubstring(String s, int k) {
       
        int subLen = 0;
        if(k == 0) return s.length();
        for(int i = 1; i <= 26; i++){
            subLen = Math.max(subLen, findLongestSubStringWithNUniques(s, k, i));
        }
        
        return subLen;
    }
    
    private int findLongestSubStringWithNUniques(String s, int k, int targetUniques){
        
        int[] count = new int[128];
        
        int uniques = 0, numUniquesNotLessK = 0;
        int start = 0, end = 0;
        int res = 0;
        
        while(end < s.length()){
            
            if(count[s.charAt(end)] == 0){
                uniques++;
            }
            count[s.charAt(end)]++;
            
            if(count[s.charAt(end)] == k){
                numUniquesNotLessK++;
            }
            end++;
            
            while(uniques > targetUniques){
                if(count[s.charAt(start)] - 1 == 0){
                    uniques--;
                }
                if(count[s.charAt(start)] == k){
                    numUniquesNotLessK--;
                }
                count[s.charAt(start)]--;
                
                start++;
            }
            
            if(uniques == targetUniques && uniques == numUniquesNotLessK){
                res = Math.max(res, end - start);
            }

        }
        return res;
    }
}