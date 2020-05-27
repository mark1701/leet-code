class Solution {
    
    public int minDistance(String word1, String word2) {
        
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();
        
        int M = word1.length();
        int N = word2.length();
        int[][] memo = new int[M][N];
        for(int i = 0; i < M; i++)
            Arrays.fill(memo[i], -1);
        
        return backtrack(word1, word2, 0, 0, memo);
    }
    
    private int backtrack(String s1, String s2, int i, int j, int[][] memo){
                    
        if(i == s1.length())
            return s2.length() - j; 
        if(j == s2.length())
            return s1.length() - i;
            
        if(memo[i][j] > 0) return memo[i][j];
        int res = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            memo[i][j] = backtrack(s1,s2,i+1,j+1,memo); //they're the same, do nothing
        } else{
            int replace = backtrack(s1,s2,i+1,j+1,memo);

            int add = backtrack(s1,s2,i,j+1,memo);
        
            int remove = backtrack(s1,s2,i+1,j,memo);
            
            memo[i][j] = Math.min(replace, Math.min(add, remove)) + 1;
        }
        return memo[i][j];
    }    
}