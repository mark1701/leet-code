class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer,List<String>> groups = new HashMap<>();
        for(String s : strs){
            int l = s.length();
            if(!groups.containsKey(l))
                groups.put(l, new ArrayList<>());
            
            List<String> list = groups.get(l);
            list.add(s);
        }
        
        List<List<String>> res = new ArrayList<>();
        for(int length : groups.keySet()){
            partition(groups.get(length),res);
        }
        
        return res;
    }
    
    private void partition(List<String> strs, List<List<String>> res){
        
        Map<Integer,List<String>> groups = new HashMap<>();
        
        for(String s : strs){
            int hc = getCode(s);
            if(!groups.containsKey(hc))
                groups.put(hc, new ArrayList<>());
            List<String> list = groups.get(hc);
            list.add(s);
        }
        for(int hc : groups.keySet()){
            res.add(groups.get(hc));
        }
        
    }
    
    private int getCode(String str){
        char[] arr = str.toCharArray(); 
        Arrays.sort(arr); 
        return (new String(arr)).hashCode();
    }
}