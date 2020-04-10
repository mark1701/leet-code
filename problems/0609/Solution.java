class Solution {
    
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(String path : paths)
            processPath(path, map);
        
        List<List<String>> res = new ArrayList<>();
        for(String k : map.keySet()){
            List<String> matches = map.get(k);
            if(matches.size() > 1)
                res.add(matches);
        }
        return res;           
    }
    
    private void processPath(String path, Map<String, List<String>> map){
        if(path == null || path.length() == 0) return;
        
        int ws = path.indexOf(" ");
        String dir = path.substring(0, ws);
        
        int fileIdx = ws+1;
        while(fileIdx < path.length()){
            int parO = path.indexOf("(", fileIdx);
            String fileName = path.substring(fileIdx, parO);
            
            int parC = path.indexOf(")", fileIdx);
            String fileContent = path.substring(parO+1, parC);

            if(!map.containsKey(fileContent))
                map.put(fileContent, new ArrayList<>());
            
            List<String> paths = map.get(fileContent);
            paths.add(dir+"/"+fileName);

            fileIdx = parC + 2;
        }
    }
}