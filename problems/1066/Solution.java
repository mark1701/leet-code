class Solution {
    int max;
    public int assignBikes(int[][] workers, int[][] bikes) {
        max = Integer.MAX_VALUE;
        boolean[] assigned = new boolean[bikes.length];
        assign(workers, bikes, assigned, 0, 0);
        return max;
    }
    
    private void assign(int[][] workers, int[][] bikes, boolean[] assigned, int worker, int sum){        
        if(worker >= workers.length){
            if (max > sum) max = sum;
            return;
        }
        
        for(int i = 0; i < bikes.length; i++){
            if(assigned[i]) continue;
            assigned[i] = true;
            assign(workers, bikes, assigned, worker+1, sum+dist(workers[worker],bikes[i]));
            assigned[i] = false;
        }        
    }
    
    private int dist(int[] w, int[] b){
        return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
    }
}