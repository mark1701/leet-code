class Solution {
    public int longestSubstring(String s, int k) {
        char[] chrs = s.toCharArray();
        return lsk(chrs,k,0,s.length()-1);
    }  
    
    private int lsk(char[] chrs, int k, int start, int end){
        if(end-start < 0) return 0;
        
        Occurrence[] count = findOccurrences(chrs, start, end);
        
        for(int i = 0; i < count.length; i++){ //26 times at max - size of alphabet
            if(count[i] != null && count[i].count < k){
                int leftLen = lsk(chrs, k, start, count[i].idx - 1);
                int rightLen = lsk(chrs, k, count[i].idx + 1, end);
                return Math.max(leftLen, rightLen);
            }
        }
        return end - start + 1;
    }
    
    private Occurrence[] findOccurrences(char[] chrs, int start, int end){
        Occurrence[] count = new Occurrence[26];
        
        for(int i = start; i <= end; i++){
            if(count[chrs[i] - 'a'] == null){
                Occurrence c = new Occurrence();
                c.count = 1;
                c.idx = i;
                count[chrs[i] - 'a'] = c;
            } else{
                count[chrs[i] - 'a'].count++;
            } 
        }
        
        return count;
    }
    
    class Occurrence{
        int idx;
        int count;
    }
    
}