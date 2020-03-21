class Solution {
    
    public boolean exist(char[][] board, String word) {

        int N = board.length;
        int M = board[0].length;
        boolean[][] visited = new boolean[N][M];

        for(int row = 0; row < N; row++)
            for(int col = 0; col < M; col++){
                if(board[row][col] != word.charAt(0)) continue;
                
                if(dfs(board, row, col, word, 0, visited)) return true;                
            }
        return false;  
    }
    
    private boolean dfs(char[][] board, int row, int col, String word, int index, boolean[][] visited){
        
        if(index >= word.length() - 1) return true;

        visited[row][col] = true;
        
        char c = word.charAt(index+1);
        List<int[]> adjs = findValidAdj(board, row, col, visited, c);
        
        boolean result = false;
        for(int[] adj : adjs){
            result = result | dfs(board, adj[0], adj[1], word, index+1, visited);
            if(result) return true;
        }
        
        if(!result)
            visited[row][col] = false;
        
        return result;
    }
    
    private List<int[]> findValidAdj(char[][] board, int row, int col, boolean[][] visited, char c){
        int N = board.length;
        int M = board[0].length;
        List<int[]> adjs = new ArrayList<>();
        
        if(row > 0 && !visited[row - 1][col] && board[row - 1][col] == c){
            adjs.add(new int[] {row - 1, col});
        }
        if(row < N - 1 && !visited[row + 1][col] && board[row + 1][col] == c){
            adjs.add(new int[] {row + 1, col});
        }
        
        if(col > 0 && !visited[row][col - 1] && board[row][col - 1] == c){
            adjs.add(new int[] {row, col - 1});
        }
        if(col < M - 1 && !visited[row][col + 1] && board[row][col + 1] == c){
            adjs.add(new int[] {row, col + 1});
        }
        
        return adjs;
    }  
        
}