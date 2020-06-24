class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        for(boolean b : visited)
            if(!b) return false;
        return true;
    }
    
    private void dfs(List<List<Integer>> rooms, int i, boolean[] visited){
        visited[i] = true;
        
        for(Integer j : rooms.get(i))
            if(!visited[j])
                dfs(rooms, j, visited);
    }
}