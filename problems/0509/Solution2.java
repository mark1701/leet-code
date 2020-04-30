class Solution {
    public int fib(int n) {  
        //solution based on 
        //https://cp-algorithms.com/algebra/fibonacci-numbers.html
        return fibonacci(n)[0];    
    }
    
    private int[] fibonacci(int n){
        if(n == 0)
            return new int[]{0, 1};
        
        int[] p = fibonacci(n/2);
        int c = p[0] * (2 * p[1] - p[0]);
        int d = p[0] * p[0] + p[1] * p[1];
        if ((n & 1) == 1)
            return new int[] {d, c + d};
        else
            return new int[] {c, d};
    }    
}