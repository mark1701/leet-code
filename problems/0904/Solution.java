class Solution {
    public int totalFruit(int[] tree) {
        
        int start = 0, end = 0;
        int maxLen = 0;
        
        //type of items currently in the window and index of their rightmost occurence
        Map<Integer, Integer> winItems = new HashMap<>();
                
        while (end < tree.length){
                
            if(!winItems.containsKey(tree[end]) && winItems.keySet().size() == 2){
                Integer[] keys = new Integer[2];
                winItems.keySet().toArray(keys);
                
                int typeToRemove = -1;
                if(winItems.get(keys[0]) < winItems.get(keys[1]))
                    typeToRemove = keys[0];
                else
                    typeToRemove = keys[1];

                    
                int rightmostOccurrence = winItems.get(typeToRemove);
                winItems.remove(typeToRemove);
                start = rightmostOccurrence+1;
            }
                
                maxLen = Math.max(maxLen, end - start + 1);
                winItems.put(tree[end], end);
                end++;
            
        }      
        return maxLen;

    }
}