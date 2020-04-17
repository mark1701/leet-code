class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    
    Map<String, int[]> dir;
    
    int[][] food;
    int foodIdx;
    
    List<List<Integer>> snake;
    int score;
    int M, N;
    
    public SnakeGame(int width, int height, int[][] food) {
        dir = new HashMap<>();
        dir.put("U", new int[]{-1,0});
        dir.put("R", new int[]{0,1});
        dir.put("D", new int[]{1,0});
        dir.put("L", new int[]{0,-1});
        
        this.food = food;
        foodIdx = 0;
        
        M = height;
        N = width;
        
        snake = new LinkedList<>();
        List<Integer> head = new ArrayList<>();
        head.add(0);
        head.add(0);
        snake.add(head);
        
        score = 0;        
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        moveHead(direction);
        
        if(foodIdx < food.length){
            int[] currFood = food[foodIdx];
            List<Integer> head = snake.get(0);
            if(head.get(0) == currFood[0] && head.get(1) == currFood[1]){
                foodIdx++;
                score++;
            } else
                retractTail();
        }else
            retractTail();
        
        return validPosition() ? score : -1;        
    }
    
    private void moveHead(String direct){
        int[] direction = dir.get(direct);
        List<Integer> head = snake.get(0);

        List<Integer> newH = new ArrayList<>();
        newH.add(head.get(0) + direction[0]);
        newH.add(head.get(1) + direction[1]);
        
        snake.add(0,newH);
    }
    
    private void retractTail(){
        snake.remove(snake.size()-1);
    }
    
    private boolean validPosition(){
        List<Integer> head = snake.get(0);
        
        int i = head.get(0);
        int j = head.get(1);
        //System.out.println("i,j: " + i + ", " + j);

        if(i < 0 || i >= M || j < 0 || j >= N) //check borders
            return false;
                
        return singleHead(head);
    }
    
    private boolean singleHead(List<Integer> head){
        int count = 0;
        for(List<Integer> h : snake){
            if(head.equals(h)) count++;
        }
        return count <=1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */