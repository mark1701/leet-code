class Solution {
    
    String maxWord = "";
    
    public String longestWord(String[] words) {
        Trie root = new Trie();
        root.isEnd = true;
        root.word = "";
        
        for(String word : words){
            addWord(root, word, 0);
        }            
        
        dfs(root);
        
        return maxWord;
    }
    
    private void dfs(Trie node){
        if(node.word.length() > maxWord.length()){
            maxWord = node.word;
        } else if(node.word.length() == maxWord.length()){
            maxWord = maxWord.compareTo(node.word) <= 0 ? maxWord : node.word;
        }
        
        for(int i = 0; i < 27; i++){
            if(node.links[i] != null && node.links[i].isEnd)
                dfs(node.links[i]);
        }    
    }
    
    private void addWord(Trie root, String word, int index){
        if(index >= word.length()) return;
        
        char c = word.charAt(index);
        Trie currentEl = root.links[c - 'a'];
        
        if(currentEl == null){
            currentEl = new Trie();
            currentEl.c = c;
            root.links[c - 'a'] = currentEl;
        }
        
        if(index == word.length() - 1){
            currentEl.isEnd = true;
            currentEl.word = word;
        }
        
        addWord(currentEl, word, index + 1);        
    }
    
    class Trie{
        char c;
        Trie[] links = new Trie[27];
        boolean isEnd;      
        String word; 
    }
}