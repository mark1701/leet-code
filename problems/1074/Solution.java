class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int M = matrix.length, N = matrix[0].length;
        int[][] sumPre = new int[M+1][N+1];
        calculatePreSum(matrix, sumPre);
        
        int count = 0;
        for(int i = 1; i < M+1; i++){
            for(int k = i; k < M+1; k++){
                count += countSumMatrix(sumPre, i, k, target);
            }
        }
        
        return count;
        
    }
    
    private void calculatePreSum(int[][] matrix, int[][] sumPre){
        for(int i = 1; i < sumPre.length; i++)
            for(int j = 1; j < sumPre[0].length; j++)
                sumPre[i][j] = sumPre[i][j-1] + sumPre[i-1][j] - sumPre[i-1][j-1] + matrix[i-1][j-1];
    }

    private int countSumMatrix(int[][] sumPre, int i, int k, int target){
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0, count = 0;
        for(int j = 1; j < sumPre[0].length; j++){
            sum = sumPre[k][j] - sumPre[i-1][j];
            if(map.containsKey(sum-target)) count += map.get(sum-target);
            map.put(sum, map.getOrDefault(sum, 0)+1);            
        }
        return count;
    }
}