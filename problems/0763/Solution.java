class Solution {
    public List<Integer> partitionLabels(String s) {
        
        char[] count = new char[128];
        for(int i = 0; i < s.length(); i++)
            count[s.charAt(i)]++;
        List<Integer> res = new ArrayList<>();
        
        int lo = 0, hi = 0;
        Set<Character> active = new HashSet<>();
        
        while(hi < s.length()){            
            active.add(s.charAt(hi));

            while(!active.isEmpty()){
                char c = active.iterator().next();

                char c1 = c;
                while(count[c] > 0){
                    c1 = s.charAt(hi++);
                    count[c1]--;
                    active.add(c1);
                    if(count[c1] == 0) active.remove(c1);
                }
            }
            res.add(hi-lo);
            lo = hi;
        }
        
        return res;
    }
}