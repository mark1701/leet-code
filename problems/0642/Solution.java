class AutocompleteSystem {

    TrieNode root;
    TrieNode curNode;
    StringBuilder sb;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode(' ');
        for(int i = 0; i < sentences.length; i++){
            addSentence(sentences[i], times[i]);
        }
        init();
    }
    
    private void init(){
        sb = new StringBuilder();
        curNode = root;
    }
    
    public List<String> input(char c) {
        PriorityQueue<Suggestion> suggestions = new PriorityQueue<>(4);
 
        if(c == '#'){
            int frequency = (curNode == null) ? 1 : (curNode.getFrequency() + 1); 
            addSentence(sb.toString(), frequency);
            init();
            return new ArrayList<>();
        }
                       
        if(curNode != null){
            curNode = curNode.getNode(c);
            findTopSuggestions(curNode, suggestions);
        }
        
        sb.append(c);
        
        List<String> res = new ArrayList<>();
        //System.out.println(suggestions.size());
        while(!suggestions.isEmpty()){
            res.add(suggestions.poll().getWord());
        }
        Collections.reverse(res);
        return res;
    }
    
    private void findTopSuggestions(TrieNode root, PriorityQueue<Suggestion> suggestions){
        if(root == null) return;
        sb.append(root.getChar());
                        //System.out.println(sb.toString());

        if(root.getFrequency() > 0){
            Suggestion s = new Suggestion(sb.toString(), root.getFrequency());
            suggestions.add(s);
            //System.out.println("adding: "+ s.getWord() + " : " + root.getFrequency());
            if(suggestions.size() == 4){
                suggestions.poll().getWord();
                //Suggestion s1 = new Suggestion("ironman", 2);
                //Suggestion s2 = new Suggestion("i love you", 3);
                //System.out.println("s1 < s2: " + s1.compareTo(s2));
                //System.out.println("removed: "+ x);
            }
        }
        
        for(TrieNode node : root.links()){
            if(node.getChar() == ' '){
                //System.out.println("size: " + node.links().size());
            }
            findTopSuggestions(node, suggestions);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
    
    private void addSentence(String s, int times){
        if(s == null || s.length() == 0 || times == 0) return;
        
        TrieNode node = root;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //if(s.equals("i love you")) System.out.println("adding: " + c);
            if(node.getNode(c) == null){
                //System.out.println("node is null, adding: " + c);
                node.add(new TrieNode(c));
            }    
            
            node = node.getNode(c);
            
            if(i == (s.length() - 1)){
                node.setFrequency(times);
            }            
        }
    }
}

class Suggestion implements Comparable<Suggestion>{
    private final String word;
    private final int frequency;
    
    public Suggestion(String word, int frequency){
        this.word = word;
        this.frequency = frequency;
    }
    
    public String getWord(){
        return word;
    }
    
    public int getFrequency(){
        return frequency;
    }
    
    public int compareTo(Suggestion that){
        if(this.getFrequency() < that.getFrequency()) return -1;
        else if(this.getFrequency() > that.getFrequency()) return 1;
        else
            return that.getWord().compareTo(this.getWord());
    }
}

class TrieNode {    
    private final char c;
    private int frequency;
    TrieNode[] links;
    int R = 27;
    
    public TrieNode(char c){
        //System.out.println("char is: [" + c + "]");
        this.c = c;
        links = new TrieNode[R];
    }
    
    public TrieNode getNode(char c){
        if(c == ' ') {
            //System.out.println("getting: [ ]");
            return links[R - 1];
        }
        return links[c - 'a'];
    }
    
    public char getChar(){
        return c;
    }
    
    public void add(TrieNode node){
        char item = node.getChar();

        if(item == ' ') {
            links[R - 1] = node;
        }else {
            links[item - 'a'] = node;
        }
    }
    
    public List<TrieNode> links(){
        List<TrieNode> adj = new ArrayList<>();
        for(int i = 0; i < links.length; i++){
            if(links[i] != null) adj.add(links[i]);
        }
        return adj;            
    }
    
    public int getFrequency(){
        return frequency;
    }
    
    public void setFrequency(int f){
        frequency = f;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */