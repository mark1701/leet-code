class Solution {
    
    private int[][] dirs = new int[][]{{1,-1},{1,0},{1,1}};
    
    public int cherryPickup(int[][] grid) {
    
        int M = grid.length, N = grid[0].length;
        
        Integer[][][] memo = new Integer[M][N][N];
        
        return dfs(grid, 0, 0, N-1, memo);
        
    }
    
    private int dfs(int[][] grid, int row, int c1, int c2, Integer[][][] memo){
        
        int M = grid.length, N = grid[0].length;
        
        if(row == M) return 0;
        
        if(memo[row][c1][c2] != null) return memo[row][c1][c2];
        
        int best = Integer.MIN_VALUE;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(c1+i < 0 || c1+i >= N || c2+j < 0 || c2+j >= N) continue;

                best = Math.max(best, dfs(grid, row+1, c1+i, c2+j, memo));
            }
        }
        
        if(c1 == c2) best += grid[row][c1];
        else best += grid[row][c1] + grid[row][c2];
        
        return memo[row][c1][c2] = best;
    }
    
    
}