class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    
    public int numDecodings(String s) {        
        return decode(s, 0, 0);
    }
    
    private int decode(String s, int start, int end){
        if(memo.containsKey(start)) return memo.get(start);
        
        if(start < s.length() && s.charAt(start) == '0') return 0;
        if(end >= s.length()){
            return 1;
        }

        int len = end - start + 1;
        int count  = 0;
        if(len == 2 || start >= s.length()-1 || Integer.parseInt(s.substring(start, end+2)) > 26){
            count += decode(s, end+1, end+1);
        } else {
            count += decode(s, start, end+1); //can expand
            count += decode(s, start+1, end+1); //but also don't expand
        }
        
        memo.put(start, count);
        return count;
    }
}