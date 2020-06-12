class Solution {
    public void setZeroes(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        int M = matrix.length;
        int N = matrix[0].length;
        
        //check if we have to nullify the first column
        boolean firstCol = false;
        for(int i = 0; i < M; i++)
            if(matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        
        //check if we have to nullify the first row
        boolean firstRow = false;
        for(int j = 0; j < N; j++)
            if(matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        
        //use the first row and first colum to record which rows and cols have to be nullified
        for(int i = 1; i < M; i++)
            for(int j = 1; j < N; j++)
                if(matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
        
        //nullify when needed
        for(int i = 1; i < M; i++)
            for(int j = 1; j < N; j++)
                if(matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0;
                
        //nullify first col id needed
        for(int i = 0; i < M; i++)
            matrix[i][0] = firstCol ? 0 : matrix[i][0];
            
        //nullify first col id needed
        for(int j = 0; j < N; j++)
            matrix[0][j] = firstRow ? 0 : matrix[0][j];
    }
}