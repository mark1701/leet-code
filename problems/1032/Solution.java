class StreamChecker {
    private Node root;
    private LinkedList<Character> buffer;
    private int BUFFER_LIMIT = Integer.MIN_VALUE;
    
    public StreamChecker(String[] words) {
        root = new Node();
        for(String w : words){
            BUFFER_LIMIT = Math.max(BUFFER_LIMIT, w.length());
            addWord(w);
        }
        
        buffer = new LinkedList<>();
    }
    
    private void addWord(String w){
        Node node = root;
        for(int i = w.length()-1; i >=0; i--){
            char c = w.charAt(i);
            Node adj = node.getAdj(c);
            if(adj == null){
                adj = node.addAdj(c);
            }
            node = adj;
        }
        node.setEnd();
    }
    
    
    public boolean query(char letter) {
        addLetterToBuffer(letter);
        return searchLastElements();
    }
    
    private void addLetterToBuffer(char c){
        if(buffer.size() == BUFFER_LIMIT){
            buffer.removeFirst();
        }
        buffer.addLast(c);
    }
    
    private boolean searchLastElements(){        
        Node node = root;
        for(int i = buffer.size()-1; i >= 0 && node != null; i--){
            char c = buffer.get(i);
            node = node.getAdj(c);
            if(node != null && node.isEnd()) return true;
        }
        return false;
    }
    
    private class Node{
        private Node[] adj = new Node[26];
        private boolean isEnd;
        
        public Node getAdj(char c){
            return adj[c-'a'];
        }
        
        public Node addAdj(char c){
            Node node = new Node();
            adj[c-'a'] = node;
            return node;
        }
        
        public void setEnd(){
            isEnd = true;
        }
        
        public boolean isEnd(){
            return isEnd;
        }
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */