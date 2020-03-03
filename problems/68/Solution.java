class Solution {   
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;
        
        int start = 0;
        while(start < words.length){
            int end = pickWords(words, start, maxWidth);
            res.add(format(words, start, end, maxWidth));
            start = end + 1;
        }
        
        return res;
    }
    
    private int pickWords(String[] words, int start, int maxWidth){
        int totalLength = words[start].length();
        int end = start;
        int space = 1;
        
        while(end + 1 < words.length && ((totalLength + space + words[end+1].length()) <= maxWidth)){
            end++;
            totalLength += space + words[end].length();
        }        
        return end;
    }
     
    private String format(String[] words, int start, int end, int maxWidth){
        if(start == end) return padRight(words[start], maxWidth);
        
        boolean isLastLine = (end == words.length - 1);
        int totalSpace = maxWidth - wordsLength(words, start, end);
        int separators = end - start;
        
        String spacesPerSeparator = isLastLine ? " " : blanks(totalSpace / separators);
        int remainingSpace = isLastLine ? 0 : totalSpace % separators;
        
        StringBuilder sb = new StringBuilder();
        for(int i = start; i <= end; i++){
            sb.append(words[i])
                .append(spacesPerSeparator)
                .append(remainingSpace-- > 0 ? " " : "");
        }
        return padRight(sb.toString().trim(), maxWidth);
    }
    
    private int wordsLength(String[] words, int start, int end){
        int totalLength = 0;
        for(int i = start; i <= end; i++)
            totalLength += words[i].length();
        return totalLength;
    }
    
    private String padRight(String word, int maxWidth){
         return word + blanks(maxWidth - word.length());
    }
    
    private String blanks(int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< n; i++)
            sb.append(' ');
        return sb.toString();
    }
            
}