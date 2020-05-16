class Solution {
    private int[][] dir = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    private Map<Integer,Integer> map = new HashMap<>();
    private Set<Integer> landConnected = new HashSet<>();
    
    public int numEnclaves(int[][] grid) {
        
        int M = grid.length, N = grid[0].length;
        
        int group = 1;  
        int zeroes = 0;
        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++){
                if(grid[i][j] == 1) dfs(grid, i, j, ++group);       
                if(grid[i][j] == 0) zeroes++;
            }       
            
        int land = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(landConnected.contains(entry.getKey()))
                land += entry.getValue();
        }
        
        return M*N-zeroes-land;
    }
    
    private void dfs(int[][] grid, int i, int j, int group){
        int M = grid.length, N = grid[0].length;                   
        
        grid[i][j] = group;
        
        if((i == 0 || i == M-1 || j == 0 || j == N-1))
            landConnected.add(group);
        
        map.put(group, map.getOrDefault(group,0)+1);

        for(int[] d : dir){
            int x = i+d[0], y = j+d[1];
            if(x < 0 || x >= M || y < 0 || y >= N) continue;
                    
            if(grid[x][y] == 1)                
                dfs(grid, x, y, group);                               
        }        
    }
}