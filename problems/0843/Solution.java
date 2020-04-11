/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        for(int i = 0; i < 10; i++){

            Map<String, Integer> count = new HashMap<>();
            for(String s1 : wordlist)
                for(String s2: wordlist)
                    if(match(s1, s2) == 0)
                        count.put(s1, count.getOrDefault(s1, 0) + 1);

            String word = "";
            int min = Integer.MAX_VALUE;
            for(String s : wordlist){
                    int val = count.getOrDefault(s,0);
                    if(val < min){
                        word = s;
                        min = val;
                    }
            }
            
            int x = master.guess(word);
            if(x == 6) return;
            List<String> newSet= new LinkedList<>();
            for(String s : wordlist){
                if(s.equals(word)) continue;
                if(match(word, s) == x)
                    newSet.add(s);
            }
            wordlist = newSet.toArray(new String[newSet.size()]);
        }
    }
    
    private int match(String v, String w){
        int matches = 0;
        for(int i = 0; i < 6; i++){
            if(v.charAt(i) == w.charAt(i))
                matches++;
        }
        return matches;
    }
}