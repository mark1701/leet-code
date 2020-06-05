class Solution {
    private int[][] dirs = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};

    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int M = board.length;
        int N = board[0].length;
        boolean[][] visited = new boolean[M][N];
        
        for(int i = 0; i < M; i++){
            if(!visited[i][0] && board[i][0] == 'O') dfs(board, i, 0, visited);
            if(!visited[i][N-1] && board[i][N-1] == 'O') dfs(board, i, N-1, visited);
        }
        
        for(int j = 0; j < N; j++){
            if(!visited[0][j] && board[0][j] == 'O') dfs(board, 0, j, visited);
            if(!visited[M-1][j] && board[M-1][j] == 'O') dfs(board, M-1, j, visited);
        }  
        
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                board[i][j] = board[i][j] == 'D' ? 'O' : 'X';
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j, boolean[][] visited){
        if(visited[i][j]) return;
        visited[i][j] = true;
        if(board[i][j] == 'O') board[i][j] = 'D';
        for(int[] d : dirs){
            int x = i + d[0], y = j + d[1];
            if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) continue;
            if(board[x][y] == 'O') dfs(board, x, y, visited);
        }
        
    }
}