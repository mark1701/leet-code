class Solution {
    public int maxTurbulenceSize(int[] A) {
        if (A.length == 1) return 1;
        
        int maxLen = 1;
        int prev = -2;
        int start = 0, end = 1;
        while(end < A.length){
                      
            int curr = Integer.compare(A[end-1], A[end]);
            if(curr == 0){
                start = end;
                end++;
                prev = -2;
                continue;
            }
            
            if(prev == -2 || curr == prev *-1){
                maxLen = Math.max(maxLen,end-start+1);
                end++;
                prev = curr;
            }else{
                start = end-1;
                prev = -2;
            }
        }
        
        return maxLen;
    }
}