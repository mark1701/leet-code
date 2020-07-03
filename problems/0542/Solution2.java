class Solution {
    
    
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
        int M = matrix.length, N = matrix[0].length;
        int[][] dist = new int[M+2][N+2];
        for(int[] d : dist)
            Arrays.fill(d, Integer.MAX_VALUE);
        
        for(int i = 1; i < M+1; i++)
            for(int j = 1; j < N+1; j++)
                if(matrix[i-1][j-1] != 0){
                    int minDist = Math.min(dist[i-1][j], dist[i][j-1]);
                    if(minDist == Integer.MAX_VALUE) continue;
                    dist[i][j] = Math.min(dist[i][j], minDist+1);
                } else dist[i][j] = 0;
        
        for(int i = M; i >= 1; i--)
            for(int j = N; j >= 1; j--)
                if(matrix[i-1][j-1] != 0){
                    int minDist = Math.min(dist[i+1][j], dist[i][j+1]);
                    if(minDist == Integer.MAX_VALUE) continue;
                    dist[i][j] = Math.min(dist[i][j], minDist+1);
                }
        
        int[][] res = new int[M][N];
        for(int i = 1; i < M+1; i++)
            for(int j = 1; j < N+1; j++)
                res[i-1][j-1] = dist[i][j];
                
        return res;
    }
    
}