class NumMatrix {
    int cols[][];
    int[][] matrix;
    
    public NumMatrix(int[][] matrix) {
        if(   matrix           == null
       || matrix.length    == 0
       || matrix[0].length == 0   ){
        return;   
        }
        
        this.matrix = matrix;
        
        int M = matrix.length;
        int N = matrix[0].length;
        cols = new int[M+1][N];
        
        for(int i = 1; i < M + 1; i++)
            for(int j = 0; j < N; j++){
                cols[i][j] = cols[i-1][j] + matrix[i-1][j];
            }
    }
    
    public void update(int row, int col, int val) {
        for(int i = row+1; i < cols.length; i++){
            cols[i][col] = cols[i][col] - matrix[row][col] + val;
        }
        
        matrix[row][col] = val;        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        
        for(int j = col1; j <= col2; j++){
            res += cols[row2+1][j] - cols[row1][j];
        }
        
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */