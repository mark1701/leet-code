class Solution {
    public String multiply(String num1, String num2) {
        
        int M = num1.length();
        int N = num2.length();
        int[] result = new int[M+N];
        
        for(int i = M-1; i >= 0; i--){
            
            int m = num1.charAt(i) - '0';
            for(int j = N-1; j >=0; j--){

                int n = num2.charAt(j) - '0';
                int pr = i + j + 1;
                int pc = i + j;
                
                int res = (n*m) + result[pr];
            
                result[pr] = res % 10;
                result[pc] += res / 10;
            }            
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.length; i++){
            if(result[i] == 0 && sb.length() == 0) continue;
            sb.append(result[i]);
        }
        return sb.length() == 0 ?  "0" : sb.toString();
    }
    
}