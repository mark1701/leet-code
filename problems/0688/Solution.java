class Solution {
    
    private int[][] dirs = new int[][]{{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};
    
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] memo = new double[N][N][K];
        for(double[][] me : memo)
            for(double[] m : me)
                Arrays.fill(m, -1.0);
        
        return moveKnight(N, K, r, c, memo);        
    }
    
    private double moveKnight(int N, int K, int r, int c,double[][][] memo){
        if(r < 0 || r >= N || c < 0 || c >= N) return 0;
        if(K == 0) return 1;
        
        if(memo[r][c][K-1] > 0) return memo[r][c][K-1];
        
        double probability = 0;
        for(int[] dir : dirs){
            int x = r + dir[0];
            int y = c + dir[1];
            probability += 0.125 * moveKnight(N, K-1, x, y, memo);
        }
        memo[r][c][K-1] = probability;
        return memo[r][c][K-1];        
    }
}