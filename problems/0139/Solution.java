class Solution {
    
    Node root;
    int count = 0;
    int[][] dp;
    
    public boolean wordBreak(String s, List<String> wordDict) {
    
        root = new Node();
        
        for(String st : wordDict){
            addWord(root, st, 0);
        }
        dp = new int[count][s.length()];
        return visit(root, s.toCharArray(), 0);
    }
    
    private boolean visit(Node parent, char[] s, int idx){
        
        if(idx == s.length) return false;
        
        char c = s[idx];
        
        Node node = parent.get(c);
       
        if(node == null) {
            return false;
        }
        
        if(dp[node.id][idx] == 1) 
            return false;
        else if(dp[node.id][idx] == 2)
            return true;
        
        if(node.isEnd() && idx == s.length - 1) {
            dp[node.id][idx] = 2;
            return true;
        }
        
        if(node.isEnd()){
            boolean result = visit(node, s, idx+1) || visit(root, s, idx+1);
            dp[node.id][idx] = result ? 2 : 1;
            return result;
        }
        else{
            boolean result = visit(node, s, idx+1);
            dp[node.id][idx] = result ? 2 : 1;
            return result;
        }
        
    }    
    
    private void addWord(Node node, String s, int idx){
        if(idx == s.length()){
            node.setEnd();
            return;
        }
        
        char c = s.charAt(idx);
        
        if(!node.contains(c)){
            node.put(c, count);
            count++;
        }
        
        addWord(node.get(c), s, idx+1);     
    }
    
    class Node{        
        private Map<Character, Node> links = new HashMap<>();
        
        private boolean isEnd;
        public int id;       
        public boolean contains(char c){
            return links.containsKey(c);
        }
        
        public void put(char c, int id){
            this.id = id;
            links.put(c, new Node());
        }
        
        public Node get(char c){
            if(links.containsKey(c)) return links.get(c); 
            return null;
        }
        
        public void setEnd(){
            isEnd = true;
        }
        
        public boolean isEnd(){
            return isEnd;
        }
    }
}