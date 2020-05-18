class Solution {
    Map<String, Integer> memo;
    private final int M = 1000000007;
    public int dieSimulator(int n, int[] rollMax) {
        memo = new HashMap<>();
        return backtrack(n, rollMax, 0, 0);    
    }
    
    private int backtrack(int n, int[] rollMax, int prevRoll, int streak){
        
        if(n == 0) {
            return 1;
        }
        
        String key = n + "-" + prevRoll + "-" + streak;
        Integer res = memo.get(key);
        if(res != null) return res;
        
        int sum = 0;
        for(int roll = 1; roll <= 6; roll++){
            if(roll == prevRoll){
                if(streak+1 <= rollMax[roll-1])
                    sum = (sum + backtrack(n-1, rollMax, roll, streak+1)) % M;
            } else{
                sum = (sum + backtrack(n-1, rollMax, roll, 1)) % M;
            }
        }        

        memo.put(key, sum);
        return sum;
    }
}