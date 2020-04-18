class Solution {
    public boolean canWin(String s) {
        char[] chars = s.toCharArray();
        return canWin(chars);        
    }
    
    private boolean canWin(char[] chars){        
        for(int i = 0; i < chars.length-1; i++){
            if(chars[i] == '+' && chars[i+1] == '+'){
                chars[i] = '-';chars[i+1] = '-';
                boolean success = !canWin(chars);
                chars[i] = '+';chars[i+1] = '+';
                if(success) return true;
            }
        }    
        return false;
    }
}