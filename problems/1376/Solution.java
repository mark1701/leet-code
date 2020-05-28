class Solution {
    
    int maxTime = 0;
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {        
        Map<Integer, Node> map = new HashMap<>();
        Node root = new Node(headID, informTime[headID]);
        map.put(headID, root);
        
        for(int i = 0; i < n; i++){
            if(i == headID) continue;
            Node node = map.getOrDefault(i, new Node(i, informTime[i]));
            map.put(i, node);
            Node parent = map.getOrDefault(manager[i], new Node(manager[i], informTime[manager[i]]));
            map.put(manager[i], parent);
            
            parent.children.add(node);            
        }
        
        dfs(root,0);
        
        return maxTime;
    }
    
    private void dfs(Node node, int timeSpent){        
        timeSpent += node.time;
        for(Node child : node.children){
            dfs(child, timeSpent);
        }
        maxTime = Math.max(maxTime, timeSpent);
        timeSpent -= node.time;
    }
    
    private class Node{
        Set<Node> children;
        
        int id;
        int time;
        public Node(int id, int time){
            this.id = id;
            this.time = time;
            children = new HashSet<>();
        }        
    }
}