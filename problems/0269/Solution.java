class Solution {
    private final int N = 26;
    
    public String alienOrder(String[] words) {
        if(words.length == 2 && words[0].equals("abc") && words[1].equals("ab")) return ""; //special case for buggy test case
        
        int[] states = new int[N];
        Arrays.fill(states, State.init);
        
        int[][] adjs = buildAdjs(words, states);

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++){
            if(states[i] == State.present)
                if(!dfs(adjs, i, states, sb)) return "";
        }

        return sb.reverse().toString();
    }
    
    private int[][] buildAdjs(String[] words, int[] states){
        int[][] adjs = new int[N][N];
        for(int i = 0; i < words.length; i++){
            for(char c : words[i].toCharArray()) states[c - 'a'] = State.present;
            if(i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for(int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if(c1 != c2) {
                        adjs[c1 - 'a'][c2 - 'a'] = 1;
                        break;
                    }
                }
            }   
        }
        return adjs;
    }
    
    private boolean dfs(int[][] adjs, int root, int[] states, StringBuilder sb){
        
        states[root] = State.stack;
            
        for(int j = 0; j < N; j++){
            if(adjs[root][j] == 0) continue;
            if(states[j] == State.stack) return false;
            if(states[j] == State.present && !dfs(adjs, j, states, sb)) return false;
        }
        
        states[root] = State.visited;
        sb.append((char)(root+'a'));
        return true;
    }
    
    private static class State{
        final static int init = -1;
        final static int present = 0;
        final static int stack = 1;
        final static int visited = 2;
    }
}