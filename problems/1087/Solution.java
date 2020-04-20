class Solution {
    public String[] expand(String s) {
        
        List<String> res = new ArrayList<>();
        
        expand(s, new StringBuilder(), res);
        
        String[] output = new String[res.size()];
        for(int i = 0; i < output.length; i++)
            output[i] = res.get(i);
        
        Arrays.sort(output);
        
        return output;
    }
    
    private void expand(String s, StringBuilder sb, List<String> res){
        
        if(s == null || s.length() == 0){
            res.add(sb.toString());
            return;
        }
        
        int openP = s.indexOf('{');
        int closeP = s.indexOf('}');
        
        int oldSize = sb.length();
        
        if(openP == -1){
            sb.append(s);
            res.add(sb.toString());
            sb.delete(oldSize, sb.length());
            return;
        }
        
        sb.append(s.substring(0, openP));
        
        String[] options = (s.substring(openP+1, closeP)).split(",");
        for(String o : options){
            
            sb.append(o);
            expand(s.substring(closeP+1), sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
        
        sb.delete(oldSize, sb.length());
        
    }
}