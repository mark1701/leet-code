class Solution {
    public int calculateTime(String keyboard, String word) {
        
        int[] chars = new int[128];
        for(int i = 0; i < 26; i++)
            chars[keyboard.charAt(i)] = i;
        
        int prev = 0;
        int time = 0;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            time += Math.abs(chars[c] - prev);
            prev = chars[c];
        }
        
        return time;            
    }
}