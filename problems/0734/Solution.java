class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1 == null && words2 == null) return true;
        if(words1 == null || words2 == null) return false;
        if(words1.length != words2.length) return false;
        
        Map<String, Set<String>> similar = new HashMap<>();
        for(List<String> p : pairs){
            if(!similar.containsKey(p.get(0)))
                similar.put(p.get(0), new HashSet<>());
            similar.get(p.get(0)).add(p.get(1));
            
            if(!similar.containsKey(p.get(1)))
                similar.put(p.get(1), new HashSet<>());
            similar.get(p.get(1)).add(p.get(0));
        }
        
        for(int i = 0; i < words1.length; i++){
            if(words1[i].equals(words2[i])) continue;
            Set<String> set = similar.get(words1[i]);
            if(set == null || !set.contains(words2[i])) return false;
        }
        
        return true;
    }
}