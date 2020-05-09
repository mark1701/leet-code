class Solution {
    public int[][] insert(int[][] intervals, int[] z) {        
        int N = intervals.length;
        
        List<int[]> overlapping = new ArrayList<>();
        for(int[] i : intervals)
          if(overlap(i,z)) overlapping.add(i);         
        
        int M = overlapping.size();
        int[] merged = merge(overlapping, z);
        
        int[][] res = new int[N-M+1][2];
        int j = 0;
        for(int i = 0; i < intervals.length; i++){
            if(overlap(intervals[i],z)) continue;
            if(merged != null && (merged[0] < intervals[i][0])){
                res[j++] = merged;
                merged = null;
            }
            res[j++] = intervals[i];            
        }
        if(M==N) 
            res[0]=z;
        else if(merged != null)
            res[res.length-1]=z;
        return res;
    }
    
    public boolean overlap(int[] i, int[] j){
        if(j[0] > i[1] || j[1] < i[0]) return false;
        return true;
    }
    
    public int[] merge(List<int[]> overlapping, int[] z){
        int[] merged = z;
        for(int[] i : overlapping){
            merged[0] = Math.min(merged[0], i[0]);
            merged[1] = Math.max(merged[1], i[1]);
        }
        return merged;
    }
}