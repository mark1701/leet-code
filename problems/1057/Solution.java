class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int N = workers.length;
        int M = bikes.length;
        
        Pairing[] pairings = new Pairing[N*M];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                Pairing p = new Pairing();
                p.worker = i;
                p.bike = j;
                p.dist = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                pairings[i*M+j] = p;
            }
        }
        
        Arrays.sort(pairings);
        
        boolean[] workersUsed = new boolean[N];
        boolean[] bikesUsed = new boolean[M];
        int[] assignements = new int[N];
        for(int k = 0; k < pairings.length; k++){
            Pairing p = pairings[k];
            int w = p.worker;
            int b = p.bike;
            
            if(workersUsed[w] || bikesUsed[b]) continue;
            
            workersUsed[w] = true;
            bikesUsed[b] = true;
            assignements[w] = b;
        }
        
        return assignements;
    }
    
    class Pairing implements Comparable<Pairing>{
        int worker;
        int bike;
        int dist;
    
        public int compareTo(Pairing that){
            return this.dist - that.dist;
        }
    }
}