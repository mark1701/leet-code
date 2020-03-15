class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null) return 0;
        
        int N = matrix.length;
        if(N == 0) return 0;
        
        int M = matrix[0].length;
        if(M == 0) return 0;
        
        int area = 0;

        int[][] mat = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(i == 0 && matrix[i][j] == '1')
                    mat[i][j] = 1;
                else if(matrix[i][j] == '1')
                    mat[i][j] = mat[i-1][j] + 1;
                
                if(area == 0 && matrix[i][j] == '1')
                    area = 1;
            }
        }
        
        
        for(int i = N-1; i >= 0; i--){
            for(int j = 0; j < M; j++){
                if(mat[i][j] <= 1) continue;
                
                int width = 1;
                int k = j;
                int maxH = mat[i][j];

                while(((k+1) < M) && mat[i][k+1] > width && width <= maxH){
                    maxH = Math.min(maxH,mat[i][k+1]);

                    width++;
                    k++;

                    area = Math.max(area, width * width);
                    if(maxH == width) break;
                }
            }
        }
        return area;
    }
}