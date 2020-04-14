class Solution {
    public int countCornerRectangles(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        
        int res = 0;
        for(int i = 0; i < M - 1; i++){
            for(int k = i+1; k < M; k++){
                int count = 0;
                for(int j = 0; j < N; j++){
                    if(grid[i][j] == 1 && grid[k][j] == 1)
                        count++;
                }
                res += count * (count -1)/2;
            }
        }
        
        return res;
    }
}