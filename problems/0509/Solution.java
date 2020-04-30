class Solution {
    public int fib(int n) {
        if(n <= 1) return n;
        
        int sum = 0;
        int sum1 = 0;
        int sum2 = 1;
        for(int i = 2; i <=n; i++){
            sum = sum1 + sum2;
            sum1 = sum2;
            sum2 = sum;
        }
        return sum;            
    }
}