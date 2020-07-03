class Solution {
    
    private int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
        int M = matrix.length, N = matrix[0].length;
        int[][] dist = new int[M][N];
        
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                if(matrix[i][j] == 0) queue.add(new int[]{i,j});
                else dist[i][j] = Integer.MAX_VALUE; 
        
        bfs(matrix, dist, queue);
        
        return dist;
    }
    
    
    private void bfs(int[][] matrix, int[][] dist, Deque<int[]> queue){
        int M = matrix.length, N = matrix[0].length;
        
        while(!queue.isEmpty()){
            int[] c = queue.poll();
                
            for(int[] dir : dirs){
                int x = c[0]+dir[0], y = c[1]+dir[1];
                if(x < 0 || x >= M || y < 0 || y >= N) continue;
                
                if(dist[c[0]][c[1]]+1 < dist[x][y]){
                    dist[x][y] = dist[c[0]][c[1]]+1;
                    queue.add(new int[]{x,y});
                }
            }
        }
    }
}