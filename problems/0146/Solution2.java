class LRUCache {
    Map<Integer, Node> nodes = new HashMap<>();
    
    Node head, tail;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node();
        tail = new Node();
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(!nodes.containsKey(key)){
            return -1;
        }
        
        Node node = nodes.get(key);
        moveToHead(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        if(nodes.containsKey(key)){
            Node node = nodes.get(key);
            node.val = value;
            moveToHead(node);
        }else{
            Node node = new Node();
            node.key = key;
            node.val = value;

            nodes.put(key,node);
            add(node);
            
            if(nodes.size() > capacity){
                Node deleted = removeFromTail();
                nodes.remove(deleted.key);
            }
        }        
    }
    
    private Node removeFromTail(){
        Node node = tail.pre;
        remove(node);
        return node;
    }
    
    private void add(Node node){
        node.pre = head;
        head.post.pre = node;
        
        node.post = head.post;
        head.post = node;
    }
    
    private void remove(Node node){
        Node pre = node.pre;
        Node post = node.post;
        pre.post = post;
        post.pre = pre;
    }
    
    private void moveToHead(Node node){
        remove(node);
        add(node);
    }
}

public class Node{
    int key;
    int val;
    
    Node pre;
    Node post;    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */