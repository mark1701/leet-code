class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            
            for (String w : dict)
                if (s.startsWith(w, i))
                    end = Math.max(end, i + w.length());
            
            bold[i] = end > i;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                sb.append(s.charAt(i));
                continue;
            }
            
            int j = i;
            while (j < s.length() && bold[j]) j++;
            sb.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }
        
        return sb.toString();
    }
}