class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Distance> pq = new PriorityQueue<Distance>(k+1, (d1, d2) -> {
            double delta = d2.val - d1.val;
            if(delta > 0.00001) return 1;
            if(delta < -0.00001) return -1;
            return 0;
        });
        
        for(int[] point : points){
            Distance d = new Distance();
            d.coordinate = point;
            d.val = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1],2));
            
            pq.add(d);
            if(pq.size() > k) pq.poll();
        }
        
        int[][] kClosest = new int[k][2];
        int count = -1;    
        while(!pq.isEmpty()){
            Distance d = pq.poll();
            kClosest[count+1] = d.coordinate;
            count++;
        }
        
        return kClosest;
    }
    
    class Distance {
        int[] coordinate;
        double val;        
    }
}