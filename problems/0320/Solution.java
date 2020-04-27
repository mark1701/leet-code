class Solution {
    
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
    
        generateAbbreviations(word.toCharArray(), 0, 0, new StringBuilder(), res);
        
        return res;
    }
    
    private void generateAbbreviations(char[] word, int idx, int count, StringBuilder sb, List<String> res){
        
        // save the len of the sb
        //when we backtrack we'll simply delete everything that comes after this len
        int len = sb.length();
        
        if(idx == word.length){
            if(count > 0) sb.append(count);
            res.add(sb.toString());
        }else{
            
            //the following approach is basically a sort of dfs with backtracking, 
            // abbreviate as much as you can and then start backtracking 
            generateAbbreviations(word, idx+1, count+1, sb, res);
        
            if(count > 0) sb.append(count);
            sb.append(word[idx]);
            generateAbbreviations(word, idx+1, 0, sb, res);
        }
        
        //backtrack!
        sb.delete(len, sb.length());
    }
}