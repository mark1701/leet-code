class Solution {
    
    int[][] moves = new int[][]{{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}}; 
    
    public int minKnightMoves(int x, int y) {
    
        int startX = 0;
        int startY = 0;
      
        if(x <= 0 && y <=0){
            startX = Math.abs(x);
            x = 0;
            startY = Math.abs(y);
            y = 0;
        } else if(x <= 0 && y >= 0){
            startX = Math.abs(x);
            x = 0;
        } else if(x >= 0 && y <=0){
            startY = Math.abs(y);
            y = 0;
        }
        
        int offset = 200;
        startX += offset;
        startY += offset;
        x += offset;
        y += offset;
        
        int[][] board = new int[800][800];
        Deque<Cell> queue = new ArrayDeque<>();
        queue.add(new Cell(startX, startY, 0));
        board[startX][startY] = 1;

        while(!queue.isEmpty()){
            Cell cell = queue.poll();
            
            int cellX = cell.x;
            int cellY = cell.y;
            if(cell.x == x && cell.y == y) return cell.dist;
            
            List<Cell> adjs = findAdj(cell, board);
            for(Cell c : adjs){
                queue.add(c);
            }            
        }
        
        return Integer.MAX_VALUE;
    }
    
    private List<Cell> findAdj(Cell cell, int[][] board){
        List<Cell> adjs = new ArrayList<>();
        for(int[] m : moves){
            int landX = cell.x + m[0];
            int landY = cell.y + m[1];
            if(landX >= 0 && landX < 600 && landY >= 0 && landY < 600 && board[landX][landY] == 0){
                board[landX][landY] = 1;
                adjs.add(new Cell(landX, landY, cell.dist+1));
            }
        }
        return adjs;
    }
    
    private class Cell{
        int x;
        int y;
        int dist;
        
        public Cell(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}