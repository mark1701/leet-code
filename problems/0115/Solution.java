class Solution {
    public int numDistinct(String s, String t) {
        if(s == null || t == null) return 0;
        int[][] memo = new int[s.length()][t.length()];
        for(int[] i : memo)
            Arrays.fill(i, -1);
        
        return count(s,t,0,0,memo);
    }
    
    private int count(String s, String t, int i, int j, int[][] memo){
        if(i == s.length() && j < t.length()) return 0;
        if(j == t.length()) return 1;
        if(memo[i][j] > -1) return memo[i][j];
        int take = 0;
        if(s.charAt(i) == t.charAt(j))
            take = count(s,t,i+1,j+1, memo);
        int notTake = count(s,t,i+1,j, memo);
        
        memo[i][j] = take + notTake;
        return memo[i][j];
    }
}