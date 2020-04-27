class Solution {
    public List<List<String>> groupStrings(String[] strs) {
        
        //main idea is that there's a sort of signature for each group
        // i.e. "abc" and "def": 
        // a = 0, b = 1, c = 2 -> normalize all letters by removing the val of the first character and 
        //you get 0,1,2 - {0,0,0} = 0,1,2
        //apply the safe for "def" and you get:
        // d=4, e=5, f=6 -> remove the val of the first character -> 4,5,6 - {4} = 0,1,2 !
        
        Map<String,List<String>> map = new HashMap<>();
        
        for(String s : strs){
            String key = getKey(s);
            List<String> group = map.getOrDefault(key, new ArrayList<>());
            group.add(s);
            map.put(key, group);
        }
        
        return new ArrayList<>(map.values());
    }
    
    private String getKey(String s){
        int offset = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        
        sb.append("0,");
        for(int j = 1; j < s.length(); j++){
            int val = s.charAt(j)-offset;
            
            //special case for when the val < 0
            //we need to add 26, otherwise a,z -> 0, 25 != b,a = 0, 1-2 = 0,-1
            //if we normalise by adding 26 instead we get b,a = 2 - 1 = -1 + 26 = 25
            sb.append(val >= 0 ? val : val + 26); 
            sb.append(",");
        }
        
        return sb.toString();
    }
}