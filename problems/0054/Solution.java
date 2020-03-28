class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;      
        
        printLayer(matrix, 0, 0, matrix.length, matrix[0].length, res);
        
        return res;
    }
    
    private void printLayer(int[][] matrix, int r, int c, int N, int M, List<Integer> res){
        
        if(N == 0 || M == 0) return;
        
        if(N == 1){
            for(int j = c; j < c+M; j++)
                res.add(matrix[r][j]);
            return;            
        }
        
        if(M == 1){
            for(int i = r; i < r+N; i++)
                res.add(matrix[i][c]);
            return;            
        }
        
        for(int j = c; j < c+M-1; j++)
            res.add(matrix[r][j]);
        
        for(int i = r; i < r+N-1; i++)
            res.add(matrix[i][c+M-1]);
        
        for(int j = c+M-1; j > c; j--)
            res.add(matrix[r+N-1][j]);
        
        for(int i = r+N-1; i > r; i--)
            res.add(matrix[i][c]);
        
        printLayer(matrix, r+1, c+1, N-2, M-2, res);
        
    }
}