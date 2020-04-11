class Solution {
    int total = 0;
    Random rnd = new Random();
    int[] sum;
    
    public Solution(int[] w) {
        sum = new int[w.length];
        for(int i = 0; i< w.length; i++){
            total += w[i];
            sum[i] = total;
        }
    }
    
    public int pickIndex() {
        int el = rnd.nextInt(total);
        int lo = 0, hi = sum.length - 1;        
        while(lo < hi){
            int mid = lo + (hi -lo)/2;
            //if(sum[mid] == el) return mid;
            
            if(sum[mid] <= el)
                lo = mid + 1;
            else
                hi = mid;            
        }
        return lo;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */