class Solution {
    public int numMatchingSubseq(String s, String[] words) {
    
        int N = words.length;
        int M = s.length();
        
        List<Node>[] map = new ArrayList[26];
        for(int i = 0; i < 26; i++) map[i] = new ArrayList();
        
        for(String w : words)
            map[w.charAt(0) - 'a'].add(new Node(w));
        
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            List<Node> nodes = map[c - 'a'];
            if(nodes.isEmpty()) continue;
            else {
                map[c - 'a'] = new ArrayList();
                for(Node n : nodes){
                    n.index++;
                    if(n.index == n.word.length())
                        count++;
                    else
                        map[n.word.charAt(n.index) - 'a'].add(n);
                }
                nodes.clear();
            }
        }            
        
        return count;
    }

    
    private class Node{
        int index;
        String word;
        
        public Node(String word){
            this.word = word;
            index = 0; 
        }
    }
}