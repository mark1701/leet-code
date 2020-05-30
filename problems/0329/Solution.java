public class Solution {
  
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
      
        int M = matrix.length;
        int N = matrix[0].length;

        int[][] memo = new int[M][N];
        
        int ans = 0;
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                ans = Math.max(ans, dfs(matrix, i, j, memo));
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        
        int M = matrix.length;
        int N = matrix[0].length;
        
        if(memo[i][j] > 0) return memo[i][j];
        
                
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            
            if (0 <= x && x < M && 0 <= y && y < N && matrix[x][y] > matrix[i][j])
                  memo[i][j] = Math.max(memo[i][j], dfs(matrix, x, y, memo));
        }
        return ++memo[i][j];
    }
}
