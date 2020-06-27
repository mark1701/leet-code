class Solution {
    private final int SUCCESS = 1;
    private final int FAILURE = 2;
    
    public boolean checkValidString(String s) {
        
        int[][] memo = new int[s.length()][s.length()+1];
        return isValid(s, 0, 0, memo);
    }
    
    private boolean isValid(String s, int idx, int sum, int[][] memo){
        if(idx == s.length()) return sum == 0;        
        if(sum < 0) return false;
        
        if(memo[idx][sum] > 0) return memo[idx][sum] == SUCCESS;
        
        char c = s.charAt(idx);        
        boolean success = false;
        
        if(c == '*')
            success = isValid(s, idx+1, sum+1, memo) || isValid(s, idx+1, sum-1, memo) || isValid(s, idx+1, sum, memo);
        else 
            success = isValid(s, idx+1, sum + (c == '(' ? 1 : -1), memo);
        
        memo[idx][sum] = success ? SUCCESS : FAILURE;
        return success;
    }
}