class Solution {
    
    int count;
    int[] nums = new int[]{0,1,6,8,9};
    int N;
    
    public int confusingNumberII(int N) {       
        this.N = N;        
        count(0);
        return count;        
    }
    
    private void count(long curr){
        if(curr > N) return;
        if(isConfusing(curr)) count++;
        
        for(int n : nums){
            if(curr == 0 && n == 0) continue;
            count(curr*10+n);
        }
    }
    
    private boolean isConfusing(long s){        
        long res = 0, x = s;
        while( x > 0){        
            int lsd = (int) (x % 10);
            if(lsd == 2 || lsd == 3 || lsd == 4 || lsd == 5 || lsd == 7) return false;
            
            if(lsd == 6) lsd = 9;
            else if(lsd == 9) lsd = 6;
            
            res = res * 10 + lsd;
            x = x / 10;
        }
        
        return s != res;
    }
    
}