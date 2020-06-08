class Solution {
    
    private int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    
    public int shortestDistance(int[][] grid) {
        
        int M = grid.length;
        int N = grid[0].length;
        if(M == 1 && N == 1) return -1;
        
        int houses = 0;
        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                if(grid[i][j] == 1) houses++;
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(grid[i][j] != 0) continue;                
                min = Math.min(min, bfs(grid, i, j, houses));
            }
        }
        

        
        return (min != Integer.MAX_VALUE) ? min : -1;
    }
    
    private int bfs(int[][] grid, int i, int j, int houses){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i,j});
        visited[i][j] = true;
        int distance = -1;
        int sum = 0;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            distance++;
            
            while(size-- > 0){
                int[] cell = queue.poll();
                
                if(grid[cell[0]][cell[1]] == 1) {
                    sum += distance;
                    houses--;
                }
                
                if(grid[cell[0]][cell[1]] != 0) continue;

                for(int[] d : dirs){
                    int x = cell[0] + d[0], y = cell[1] + d[1];
                    if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) continue;
                    if(!visited[x][y]) {
                        visited[x][y] = true;
                        queue.add(new int[]{x,y});
                    }
                }                
            }
                
        }
            
        return houses == 0 ? sum : Integer.MAX_VALUE;
    }     
}