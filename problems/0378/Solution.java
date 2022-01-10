 public int kthSmallest(int[][] matrix, int k) {
        int M = matrix.length, N= matrix[0].length;
        
        int lo = matrix[0][0], hi = matrix[M-1][N-1];        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(countK(matrix, mid, k)) hi = mid; 
            else lo = mid+1;                       
        }
        
        return lo;
    }
    
    private boolean countK(int[][] matrix, int x, int k){
        int M = matrix.length, N= matrix[0].length;
        
        int count = 0;
        int i = 0, j = 0;
        
        while(i < M && matrix[i][0] <= x){
            
            while(j < N && matrix[i][j] <= x){
                count++; j++;
                if(count == k) return true;                
            }
            
            j = 0; i++;
        }
        
        return count >= k;
    }