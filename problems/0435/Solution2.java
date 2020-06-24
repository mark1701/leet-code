class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals == null || intervals.length == 0) return 0;
        int N = intervals.length;
        
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        
        int count = 0, prev = 0;
        
        for(int i = 1; i < N; i++){
            if(intervals[i][0] < intervals[prev][1])
                count++;
            else
                prev = i;
        }
        
        return count;
    }
}