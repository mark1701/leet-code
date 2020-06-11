 public int lastStoneWeightII(int[] stones) {
        
        int[][] memo = new int[30][6000];
        for(int[] m : memo)
            Arrays.fill(m, -1);
        
        return minWeight(stones, 0, 0, memo);       
    }
    
    private int minWeight(int[] stones, int idx, int sum, int[][] memo){
        if(idx == stones.length){
            return sum >= 0 ? sum : 100;
        }
        
        if(memo[idx][sum + 3000] > -1) return memo[idx][sum+3000];
        
        int positive = minWeight(stones, idx+1, sum + stones[idx], memo);
        int negative = minWeight(stones, idx+1, sum - stones[idx], memo);
        memo[idx][sum+3000] = Math.min(positive, negative);
        return memo[idx][sum+3000];        
    }