class Solution {
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        if(digits.equals("") || digits.contains("1")) return res;        
        
        List<Character>[] letters = (List<Character>[]) new ArrayList[10];
        populate(letters);
        
        
        StringBuilder sb = new StringBuilder();
        generate(letters, digits, 0, sb, res);
        return res;
    }
    
    private void generate(List<Character>[] letters, String digits, int idx, StringBuilder sb, List<String> res){
        if(idx == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        int d = Character.getNumericValue(digits.charAt(idx));        
        if(d == 1) {
            generate(letters, digits, idx+1, sb, res);
        } else{
            List<Character> chars = letters[d];
            for(char i : chars){
                sb.append(i);
                generate(letters, digits, idx+1, sb, res);
                sb.deleteCharAt(sb.length() -1);            
            }      
        }  
    }
    
    private void populate(List<Character>[] letters){
        letters[1] = new ArrayList();
        letters[2] = new ArrayList(List.of('a','b','c'));
        letters[3] = new ArrayList(List.of('d','e','f'));
        letters[4] = new ArrayList(List.of('g','h','i'));
        letters[5] = new ArrayList(List.of('j','k','l'));
        letters[6] = new ArrayList(List.of('m','n','o'));
        letters[7] = new ArrayList(List.of('p','q','r','s'));
        letters[8] = new ArrayList(List.of('t','u','v'));
        letters[9] = new ArrayList(List.of('w','x','y','z'));
    }
}