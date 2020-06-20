class Solution {
    
    private int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int M = grid.length;
        int N = grid[0].length;
        
        boolean[][] visited = new boolean[M][N];
        int maxArea = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && grid[i][j] == 1)
                    maxArea = Math.max(maxArea, dfs(grid, i, j, visited));
            }
        }
        return maxArea;
    }
    
    private int dfs(int[][] grid, int r, int c, boolean[][] visited){
        
        visited[r][c] = true;
        
        int sum = 1;
        for(int[] dir : dirs){
            int x = r + dir[0];
            int y = c + dir[1];
            if(isValid(grid,x,y) && !visited[x][y] && grid[x][y] == 1)
                sum += dfs(grid, x, y, visited);
        }
        
        return sum;
    }
    
    private boolean isValid(int[][] grid, int x, int y){
        return x >= 0 && x < grid.length && y >=0 && y < grid[0].length;
    }
}