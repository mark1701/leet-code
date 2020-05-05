class Solution {
    public int characterReplacement(String s, int k) {
        
        if(s == null || s.length() == 0) return 0;
        
        int N = s.length();
        int[] count = new int[128];
        
        int start = 0, maxLen = 0, maxCount = 0;
        
        for(int end = 0; end < N; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end)]);
            
            while(end - start + 1 - maxCount > k){
                count[s.charAt(start)]--;
                start++;
            }
            
            maxLen = Math.max(maxLen, end - start + 1);
        }
        
        return maxLen;
    }
}