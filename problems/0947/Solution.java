class Solution {
    int count = 0;

    public int removeStones(int[][] stones) {

        int N = stones.length;
        boolean[] visited = new boolean[N];
        int count = 0;
        
        for(int i = 0; i < N; i++)
                if(!visited[i]){
                    count++;
                    dfs(stones, i, visited);
                }
        
        return N - count;
    }
    
    private void dfs(int[][] stones, int k, boolean[] visited) {
        
        visited[k] = true;        
        
        for(int i = 0; i < stones.length; i++){            
            if(visited[i]) continue;
            if(stones[k][0] == stones[i][0] || stones[k][1] == stones[i][1] ){
                dfs(stones, i, visited);
            }
        }
        
      
    }
}