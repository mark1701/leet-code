class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int N = name.length(), T = typed.length();
        if(N > T) return false;
        
        int j = 0;
        for(int i = 0; i < N; i++){
            
            int count = 1;
            char curr = name.charAt(i);
            while(i+1 < N && name.charAt(i+1) == curr) {
                count++;
                i++;
            }
            while(j < T && typed.charAt(j) == curr){
                    count--;
                    j++; 
            }
            
            if(count > 0) return false;
        }
        return j == T;
    
    }
}