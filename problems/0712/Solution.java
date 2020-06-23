class Solution {
    public int minimumDeleteSum(String s1, String s2) {
                
        int[][] memo = new int[s1.length()][s2.length()];
        for(int[] m : memo)
            Arrays.fill(m, -1);
        
        return delete(s1, s2, 0, 0, memo);
    }
    
    private int delete(String s1, String s2, int i, int j, int[][] memo){
        int res = 0;

        if(i == s1.length() && j == s2.length()) return res;
        if(i == s1.length() || j == s2.length()){
            while(i < s1.length()) res += s1.charAt(i++);
            while(j < s2.length()) res += s2.charAt(j++);
            return res;
        }
        
        if(memo[i][j] > -1) return memo[i][j];        
        
        if(s1.charAt(i) == s2.charAt(j))
            memo[i][j] = delete(s1,s2,i+1,j+1,memo);
        else{
            memo[i][j] = Math.min(s1.charAt(i) + delete(s1,s2,i+1,j,memo), s2.charAt(j) + delete(s1,s2,i,j+1,memo));
        }
        
        return memo[i][j];
    }
}