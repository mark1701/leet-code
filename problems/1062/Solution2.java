//overall time complexity is O(n^2 log n)
class Solution {
    public int longestRepeatingSubstring(String s) {
        String[] suffixes = generateSuffixes(s); //O(n^2)
        Arrays.sort(suffixes); //O(n^2 log n)
        
        int maxLen = 0;
        for(int len = 0; len < suffixes.length - 1; len++){ // n suffixes
            int lcpLen = findLenOfLCP(suffixes[len], suffixes[len+1]); //O(n)
            maxLen = Math.max(maxLen, lcpLen);
        }
        
        return maxLen;
    }
    
    private int findLenOfLCP(String s1, String s2){
        int N = Math.min(s1.length(), s2.length());

        for(int k = 0; k < N; k++){
            if(s1.charAt(k) != s2.charAt(k))
                return k;
        }
        
        return N;
    }
    
    private String[] generateSuffixes(String s){
        String[] suffixes = new String[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            suffixes[i] = s.substring(i);
        }
        
        return suffixes;        
    }
}