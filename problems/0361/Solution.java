class Solution {
    public int maxKilledEnemies(char[][] grid) {
        
    if(grid == null || grid.length == 0 ||  grid[0].length == 0) return 0;
        int M = grid.length;
        int N = grid[0].length;
        
        int rowSum = 0;
        int[] colSum = new int[grid[0].length];
        int max = 0;
        
        for(int i =0; i < M; i++){
            for(int j = 0; j < N; j++){
                
                if(grid[i][j] == 'W') continue;
                //if it's the beginning of a row or after a W
                if(j == 0 || grid[i][j-1] == 'W'){
                    rowSum = sumRow(grid, i, j); 
                }
                //if it's the beginning of a column or after a W
                if(i==0 || grid[i-1][j] == 'W'){
                    colSum[j] = sumCol(grid, i, j);
                }
                
               // System.out.println("i,j: " + i + "," + j + " row sum: " + rowSum);
                //System.out.println("i,j: " + i + "," + j + " col sum: " + colSum);
                if(grid[i][j] == '0'){
                    max = Math.max(max, rowSum + colSum[j]);
                }
            }
        }
        
        return max;
    }
    
    private int sumRow(char[][] grid, int i, int j){
        int sum = 0;
        for(int k = j; k < grid[0].length; k++){
            if(grid[i][k] == 'W') break;
            sum += grid[i][k] == 'E' ? 1 : 0;
        }
        return sum;
    }
    
    private int sumCol(char[][] grid, int i, int j){
        int sum = 0;
        for(int k = i; k < grid.length; k++){
            if(grid[k][j] == 'W') break;
            sum += grid[k][j] == 'E' ? 1 : 0;
        }
        return sum;
    }
}