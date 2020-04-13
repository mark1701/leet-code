class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int M = matrix.length;
        int N = matrix[0].length;
        
        for(int i = 0; i < M; i++){
            if(matrix[i][0] > target) break;
            
            int lo = 0, hi = N-1;
            
            while(lo < hi){
                int mid = lo + (hi - lo+1)/2;

                if(matrix[i][mid] > target)
                    hi = mid - 1;
                else
                    lo = mid;                
            }
            if(matrix[i][lo] == target) return true;            
        }
        
        return false;        
    }
}