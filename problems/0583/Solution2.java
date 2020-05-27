class Solution {
    public int minDistance(String w, String v) {
       
        if(w == null || v == null) return 0;
        if(w == null || w.length() == 0) return v.length();
        if(v == null || v.length() == 0) return w.length();
        
        int M = w.length(), N = v.length();
        int[][] steps = new int[M+1][N+1];
        for(int i = 0; i <=M; i++){
            steps[i][0] = i;
        }
        for(int j = 0; j <=N; j++){
            steps[0][j] = j;
        }
        
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                if(w.charAt(i-1) == v.charAt(j-1)){
                    steps[i][j] = steps[i-1][j-1];
                }else{
                    steps[i][j] = Math.min(steps[i-1][j],steps[i][j-1])+1;
                }
            }
        }
        return steps[M][N];     
    }
}