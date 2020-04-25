class Solution {
    public int countSubstrings(String s) {
        
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j <= s.length(); j++){
                String sub = s.substring(i, j);
                if(isPalindrome(sub)) count++;
            }
        }
        return count;
    }
    
    private boolean isPalindrome(String s){
        if(s.length() == 0) return true;
        
        int left = 0;
        int right = s.length()-1;
        
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        
        return true;
    }
    
}