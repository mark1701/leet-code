class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals == null || intervals.length == 0) return 0;
        int N = intervals.length;
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int count = 0, prev = 0;
        
        for(int i = 1; i < N; i++){
            if(intervals[prev][1] > intervals[i][0]){ //overlaps
                if(intervals[prev][1] > intervals[i][1])
                    prev = i;
                count++;
            } else{
                prev = i;
            }
        }
        
        return count;
    }
}