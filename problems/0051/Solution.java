class Solution {
    public List<List<String>> solveNQueens(int N) {
       
        char[][] board = new char[N][N];
        for(char[] row : board)
            Arrays.fill(row, '.');
        
        List<List<String>> solutions = new ArrayList<>();
        solveQueens(board, N-1, solutions);        
        return solutions;        
    }
    
    private void solveQueens(char[][] board, int N, List<List<String>> solutions){
        
        if(N < 0){
            solutions.add(construct(board));
            return;
        }
        
        for(int i = 0; i < board.length; i++){
                if(isAttacked(board, i, N)) continue;

                board[i][N] = 'Q';
                solveQueens(board, N - 1, solutions);
                board[i][N] = '.';
        }
    }

    private boolean isAttacked(char[][] board, int row, int col){
        
        //check row
        for(int j = 0; j < board.length; j++)
            if(board[row][j] == 'Q') return true;
        
        //check col
        for(int i = 0; i < board.length; i++)
            if(board[i][col] == 'Q') return true;
        
       for(int i = 0; i < board.length; i++)
           for(int j = 0; j < board.length; j++)
               if(((i + j) == (row + col)) && board[i][j] == 'Q')
                   return true;
        
        for(int i = 0; i < board.length; i++)
           for(int j = 0; j < board.length; j++)
               if(((i - j) == (row - col)) && board[i][j] == 'Q')
                   return true;
        
        return false;
                
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}