class Solution {
    int max;
    boolean[][] visited;
    int[][] grid;
    
    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        
        int N = grid.length;
        int M = grid[0].length;
        visited = new boolean[N][M];
        
        max = 0;
        
        for(int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                visit(i,j,0);            
        
        return max;
    }
    
    private void visit(int i, int j, int val){
        if(grid[i][j] == 0) return;
        int N = grid.length;
        int M = grid[0].length;

        visited[i][j] = true;
        val += grid[i][j];
        
        if(i > 0 && !visited[i-1][j]){
            visit(i-1,j,val);
        }
        if(j > 0 && !visited[i][j-1]){
            visit(i,j-1,val);
        }
        if(i < N-1 && !visited[i+1][j]){
            visit(i+1,j,val);
        }
        if(j < M-1 && !visited[i][j+1]){
            visit(i,j+1,val);
        }
        max = Math.max(max, val);        
        visited[i][j] = false;
    }
}