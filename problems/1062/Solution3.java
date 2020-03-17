// overall complexity is O(n^2 log n)
class Solution {
    public int longestRepeatingSubstring(String s) {
        
        int start  = 1;
        int end = s.length();
        
        while(start <= end){ // log n times
            
            int mid = start + (end - start) / 2;
            if(search(s,mid)){ // O(n^2)
                start = mid + 1;
            } else{
                end = mid - 1;
            }
            
        }
        
        return start - 1;
    }
    
    private boolean search(String s, int len){
        
        Set<String> set  = new HashSet<>();
        
        for(int i = 0; i <= s.length() - len; i++){ // n times worst case
            String sub = s.substring(i, i + len); //O(n)
            if(set.contains(sub))
                return true;
            else
                set.add(sub);
        }
        
        return false;
    }
}