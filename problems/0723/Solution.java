class Solution {
    
    boolean stable = false; 
    
    public int[][] candyCrush(int[][] board) {
        
        int[][] next = new int[board.length][board[0].length];
        
        while(!stable){
            stable = true;
            
            crush(board, next);
            collapse(next);

            if(stable) break;
            
            int[][] tmp = next;
            next = board;
            board = tmp;  
        }
        return board;
    }
    
    private void collapse(int[][] board){
        int M = board.length;
        int N = board[0].length;
        
        for(int i = M-1; i > 0; i--){
            for(int j = 0; j < N; j++){
                if(board[i][j] == 0){
                    int k = i;
                    while(k > 0 && board[k][j] == 0) k--;
                    if(board[k][j] != 0){
                        board[i][j] = board[k][j];
                        board[k][j] = 0;
                        stable = false;
                    }
                }
            }
        }
    }
    
    private void crush(int[][] board, int[][] board2){
        int M = board.length;
        int N = board[0].length;
        
        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                board2[i][j] = board[i][j];
            
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                
                if(threeDown(board, i, j)){
                    
                    stable = false;
                    crushDown(board2, i, j);
                }
                
                if(threeRight(board, i ,j)){
                    stable = false;
                    crushRight(board2, i, j);
                }
                
                
            }
        }
    }
    
    private boolean threeDown(int[][] board, int i, int j){
        int M = board.length;
        if(i > M - 3) return false;
        return (board[i][j] != 0 && board[i][j] == board[i+1][j]) && (board[i][j] == board[i+2][j]);
    }
    
    private void crushDown(int[][] board, int i, int j){
        int M = board.length;
        if(i > M - 3) return;
        board[i][j] = board[i+1][j] = board[i+2][j] = 0;
    }
    
    private boolean threeRight(int[][] board, int i, int j){
        int N = board[0].length;
        if(j > N - 3) return false;
        return (board[i][j] != 0 && board[i][j] == board[i][j+1]) && (board[i][j] == board[i][j+2]);
    }
    
    private void crushRight(int[][] board, int i, int j){
        int N = board[0].length;
        if(j > N - 3) return;
        board[i][j] = board[i][j+1] = board[i][j+2] = 0;
    }    
}