class Solution {
    
    private final int LEFT = 0;
    private final int UP = 1;
    private final int RIGHT = 2;
    private final int DOWN = 3;
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        int N = maze.length;
        int M = maze[0].length;
        boolean[][][] visited = new boolean[N][M][4];
        
        boolean found = false;
        for(int direction : getAvailableDirections(maze, start))
            found = found || findDestination(maze, start, direction, destination, visited);
        
        return found;
    }
    
    private boolean findDestination(int[][] maze, int[] start, int direction, int[] destination, boolean[][][] visited){
        int i = start[0];
        int j = start[1];
        if(visited[i][j][direction]) return false;
                //System.out.println("visiting [" + i + "," + j + "] and going: " + direction);

        visited[i][j][direction] = true;
        if(i == destination[0] && j == destination[1]) {
            //System.out.println("found");
            return true;
        
        }
        
        while (direction == UP && i - 1 >= 0 && maze[i - 1][j] != 1) i--;     
        while (direction == LEFT && j - 1 >= 0 && maze[i][j - 1] != 1) j--;     
        while (direction == DOWN && i + 1 < maze.length && maze[i + 1][j] != 1) i++;     
        while (direction == RIGHT && j + 1 < maze[0].length && maze[i][j + 1] != 1) j++;     
                        
        boolean found = false;
        for(int d : getAvailableDirections(maze, new int[]{i,j}))
            found = found || findDestination(maze, new int[]{i,j}, d, destination, visited);
        
        return found;       
    }
    
    private List<Integer> getAvailableDirections(int[][] maze, int[] origin){
        List<Integer> directions = new ArrayList<>();
        int i = origin[0];
        int j = origin[1];
        
        if (i - 1 >= 0 && maze[i-1][j] != 1) directions.add(UP);     
        if (j - 1 >= 0 && maze[i][j-1] != 1) directions.add(LEFT);     
        if (i + 1 < maze.length && maze[i+1][j] != 1) directions.add(DOWN);     
        if (j + 1 < maze[0].length && maze[i][j+1] != 1) directions.add(RIGHT);
        
        return directions;
    }
}