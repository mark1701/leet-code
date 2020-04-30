class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            x = 1/x;
            N = -N;
        }
        
        double res = 1.0;
        while(N > 0){
            if((N & 1) == 1)
                res = res * x;
            x *= x;
            N /= 2;
        }
        return res;
    }  
}