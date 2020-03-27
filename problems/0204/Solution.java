class Solution {
    public int countPrimes(int n) {
        if(n <= 1) return 0;
        
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);        
       
        sieveOfE(n, isPrime);
        
        return countPrimes(isPrime);
    }
    
    private void sieveOfE(int n, boolean[] isPrime){
        
        isPrime[0] = false;
        isPrime[1] = false;
        
        int m = (int) Math.sqrt(n);
        
        for(int i = 2; i <= m; i++){
            if(isPrime[i]){
                for(int k = i*i; k < n; k+=i){
                    isPrime[k] = false;
                }
            }
            
        }
    }
    
    private int countPrimes(boolean[] isPrime){        
        int count = 0;
        for(boolean p : isPrime)
            if(p) count++;
        
        return count;
    }
}
