class Solution {
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0) return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        
        String[] tokens = input.split("\n");
        for(String t : tokens){
            String name = t.replaceAll("\t+", "");
            int depth = t.length() - name.length();
            if(name.contains(".")){
                maxLen = Math.max(maxLen,map.getOrDefault(depth,0) + name.length());
            }else if(!map.containsKey(depth+1)){
                map.put(depth+1,map.getOrDefault(depth, 0) + name.length() + 1);
            }else {
                map.replace(depth+1,map.getOrDefault(depth, 0) + name.length() + 1);
            }
        }
        
        return maxLen;
    }
}