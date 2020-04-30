class Solution {
    public double myPow(double x, int n) {

        long N = n;
        
        if(N < 0){
            N = -N;
            x = 1/x;
        }
        
        double res = 1;
        for(long i = 0; i < N; i++){
            res *= x;
        }
        return res;
    }
}