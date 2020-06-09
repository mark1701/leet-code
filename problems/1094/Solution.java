class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> ends = new TreeMap<>();
        
        int position = trips[0][1];
        for(int[] trip : trips){
            while(!ends.isEmpty() && ends.firstKey() <= trip[1]){
                capacity+= ends.pollFirstEntry().getValue();
            }
            
            capacity -= trip[0];
            if(capacity < 0) return false;
            ends.put(trip[2], ends.getOrDefault(trip[2],0) + trip[0]);
        }
        return true;
    }
}