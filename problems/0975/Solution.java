class Solution {
    
    public int oddEvenJumps(int[] A) {
        if(A == null || A.length == 0) return 0;
        
        int N = A.length;
        boolean[][] dp = new boolean[N][2];
        dp[N-1][0] = dp[N-1][1] = true;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[N-1], N-1);
        
        int count = 1;
        
        for(int i = N - 2; i >= 0; i--){
            int val = A[i];
            Map.Entry max = map.ceilingEntry(val), min = map.floorEntry(val);
            if(max != null && dp[(int) max.getValue()][1]){
                dp[i][0] = true;
                count++;
            }
            
            if(min != null && dp[(int) min.getValue()][0])
                dp[i][1] = true;
            
            map.put(val, i);              
        }
        
        return count;
    }    
  
}