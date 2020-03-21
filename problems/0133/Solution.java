/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node root) {
        if(root == null) return null;
        
        Set<Node> visited = new HashSet<>();
        Map<Integer, Node> map = new HashMap<>();
        Node node = new Node(root.val);
        map.put(node.val, node);
        dfs(root, node, visited, map);
        return node;
    }
    
    private void dfs(Node orig, Node node, Set<Node> visited, Map<Integer, Node> map){       
        if(visited.contains(orig)) return;
        visited.add(orig);
        for(Node adj : orig.neighbors){
                Node newAdj = null;
                if(map.containsKey(adj.val))
                    newAdj = map.get(adj.val);
                else{
                    newAdj = new Node(adj.val);
                    map.put(adj.val, newAdj);
                }
                if(!newAdj.neighbors.contains(node))
                    newAdj.neighbors.add(node);
                if(!node.neighbors.contains(newAdj))
                    node.neighbors.add(newAdj);
                dfs(adj, newAdj, visited, map);
        }
    }
    
}