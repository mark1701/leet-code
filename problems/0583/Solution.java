class Solution {
    public int minDistance(String w, String v) {
       
        if(w == null || v == null) return 0;
        if(w == null || w.length() == 0) return v.length();
        if(v == null || v.length() == 0) return w.length();
        int[][] memo = new int[w.length()][v.length()];
        for(int[] r: memo)
            Arrays.fill(r,-1);
        
        return convert(w,v,0,0,memo);
        
    }
    
    private int convert(String w, String v, int i, int j, int[][] memo){
        
        if(i == w.length()) return v.length() - j;
        if(j == v.length()) return w.length() - i;
        
        if(memo[i][j] > -1) return memo[i][j];
        
        if(w.charAt(i) == v.charAt(j)){
            memo[i][j] = convert(w,v,i+1,j+1, memo);
        }else{
            int replaceW = convert(w,v,i+1,j, memo);
            int replaceV = convert(w,v,i,j+1, memo);
            memo[i][j] = Math.min(replaceW,replaceV) + 1;
        }
        return memo[i][j];
    }
}