class Solution {
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        
        if(maze == null || maze.length == 0 || maze[0].length == 0) return -1;
        
        int M = maze.length;
        int N = maze[0].length;
        
        boolean[][] visited = new boolean[M][N];
        int[][] directions = new int[][] {{1,0}, {0,1}, {-1,0}, {0, -1}};
        
        Queue<Step> queue = new PriorityQueue<>(10, (a,b) -> a.dist - b.dist);
        queue.offer(new Step(start[0], start[1], 0));
        
        while(!queue.isEmpty()){
            Step step = queue.poll();
            if(visited[step.x][step.y]) continue;
            visited[step.x][step.y] = true;
            
            if(reachedDestination(step, destination))
                return step.dist;
            
            List<Step> adjs = findUnvisitedAdjs(step, maze, directions, visited);
            
            for(Step adj : adjs){
                queue.add(adj);
            }
        }
        return -1;
    }
    
    private boolean reachedDestination(Step step, int[] dest){
        return step.x == dest[0] && step.y == dest[1];
    }
    
    private List<Step> findUnvisitedAdjs(Step step, int[][] maze, int[][] directions, boolean[][] visited){
        
        int M = maze.length;
        int N = maze[0].length;
        List<Step> adjs = new ArrayList<>();
        
        for(int[] dir : directions){
            
            int nextX = step.x;
            int nextY = step.y;
            
            while(nextX + dir[0] >= 0 && nextX + dir[0] < M && nextY + dir[1] >= 0 && nextY + dir[1] < N){
                if(maze[nextX + dir[0]][nextY + dir[1]] == 1) break;
                nextX += dir[0];
                nextY += dir[1];
            }
            
            if(visited[nextX][nextY]) continue;
            
            int newDist = (nextX != step.x) ? Math.abs(nextX - step.x) : Math.abs(nextY - step.y);
            
            Step newStep = new Step(nextX, nextY, step.dist+newDist);
            adjs.add(newStep);
        }
        return adjs;
    }
    
    private class Step {
        int dist;
        int x;
        int y;
        
        public Step(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this. dist = dist;
        }
    }
}