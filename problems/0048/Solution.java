class Solution {
    public void rotate(int[][] matrix) {
        rotateRing(matrix, 0, 0, matrix.length);
    }
    
    private void rotateRing(int[][] matrix, int x, int y, int size){
        if(size <= 1) return;

        for(int j = y; j < y+size-1; j++)
            rotateCell(matrix, x, j);
        
        rotateRing(matrix, x+1, y+1, size-2);
    }
    
    private void rotateCell(int[][] matrix, int i, int j){
        int n = matrix.length;
        int edge = n-1;
        int temp = matrix[edge - j][i];
        matrix[edge - j][i] = matrix[edge - i][edge - j];
        matrix[edge - i][edge - j] = matrix[j][edge -i];
        matrix[j][edge - i] = matrix[i][j];
        matrix[i][j] = temp;
    }
}