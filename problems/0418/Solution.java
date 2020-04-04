class Solution {
    public int wordsTyping(String[] sentence, int N, int M) {
    
        int currWord = 0;
        int count = 0;
        
        for(int i = 1; i <= N;){            
            for(int j = 1; j <= M;){
           
                int wordLen = sentence[currWord].length();                 
                if(j + wordLen - 1 <= M) {
                    j += wordLen; 
                    currWord++;
                    if(j <= M) j++;
                } else {
                    j = 1;
                    i++;
                }               
                   
            if(currWord == sentence.length) {
                        currWord = 0;
                        count++;
                    if(i < N && j + sentence[0].length()-1 > M){
                        
                        int d = N / i;
                        int m = N % i;
                        count = count *d;

                        i = (i * d)+1;
                        j=1;
                    }
                }
                
                if(i > N) return count; 
                if(j > M){
                    j = 1;
                    i++;
                }
                if(i > N) return count;
               
            }
        }
        return count;
    }
}