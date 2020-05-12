class Solution {
    public int numberOfSubarrays(int[] A, int k) {
        return atMost(A, k) - atMost(A, k - 1);
    }

    public int atMost(int[] A, int k) {
        
        int res = 0;
        int j = 0;
        for(int i = 0; i < A.length; i++){
            k -= A[i] % 2;
            while (k < 0){
                k += A[j++] % 2;    
            }
            
            res += i - j + 1; 
        }
        
        return res;
    }
    
    
}