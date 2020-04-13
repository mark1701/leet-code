class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int M = matrix.length;
        int N = matrix[0].length;
        
        int i = 0, j = N - 1;
        
        while(i < M && j >= 0){
            if(target == matrix[i][j]) return true;
            if(target > matrix[i][j])
                i++;
            if(i < M && target < matrix[i][j])
                j--;
        }
        return false;
              
    }
}