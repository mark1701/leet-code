class Solution {
    private final String START = "0000";
    
    public int openLock(String[] deadends, String target) {        
        
        Map<String, Boolean> blocks = new HashMap<>();
        for(String s : deadends)
            blocks.put(s, true);
        
        if(blocks.containsKey(START)) return -1;
        if(START.equals(target)) return 0;
        
        Deque<String> queue = new ArrayDeque<>();
        queue.add(START);
        
        int min = 0;
        
        Set<String> visited = new HashSet<>();
        visited.add(START);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            while(size > 0){
                String comb = queue.poll();            
                if(blocks.containsKey(comb)){
                    size--;
                    continue;                    
                }             

                if(comb.equals(target)) return min;

                List<String> adj = findAdjCombs(comb);
                for(String c : adj){
                    if(!blocks.containsKey(c) && !visited.contains(c)){
                        visited.add(c);
                        queue.add(c);
                    }                        
                }
                size--;
            }
            min++;
        }
        
        return -1;        
    }
    
    private List<String> findAdjCombs(String comb){
        List<String> adjs = new ArrayList<>();
        char[] chars = comb.toCharArray();
        
        for(int i = 0; i < 4; i++){
            char c = chars[i];            
            
            char next = getNext(c);
            char prev = getPrev(c);
            
            chars[i] = next;
            adjs.add(new String(chars));
            chars[i] = prev;
            adjs.add(new String(chars));
            chars[i] = c;            
        }
        
        return adjs;
    }
    
    private char getNext(char c){
        if(c == '9') return '0';
                    
        int d = Character.getNumericValue(c);
        d++;
        return (char) ('0' + d);
    }
    private char getPrev(char c){
        if(c == '0') return '9';
                    
        int d = Character.getNumericValue(c);
        d--;
        return (char) ('0' + d);
    }
}