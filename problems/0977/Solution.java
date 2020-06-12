class Solution {
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        
        int idx = 0;
        for(idx = 0; idx < N && A[idx] <= 0; idx++);
                
        int lo = idx -1, hi = idx;
        int output[] = new int[N];
        idx = 0;
        while(lo >= 0 || hi < N){            
            while(hi < N && (lo < 0 || Math.abs(A[hi]) <= Math.abs(A[lo]))){
                output[idx++] = (int) Math.pow(A[hi++],2);
            }
            while(lo >= 0 && (hi >= N || Math.abs(A[lo]) <= Math.abs(A[hi]))){
                output[idx++] = (int) Math.pow(A[lo--],2);
            }
        }
        return output;
    }
}