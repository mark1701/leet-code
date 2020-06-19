class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) return 0;
        
        sortEnvelopes(envelopes);        
        int[] heights = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++){
            heights[i] = envelopes[i][1];
        }
        
        return findLIS(heights);            
    }
    
    private int findLIS(int[] heights){
        int N = heights.length;
        int[] dp = new int[N];
        int len = 0;
        for(int h : heights){
            int i = Arrays.binarySearch(dp, 0, len, h);
            if(i < 0) i = -(i+1);
            dp[i] = h;
            if(i == len)
                len++;
        }   
        return len;
    }
    
    private boolean isBigger(int[] a, int[] b){
        return a[0] > b[0] && a[1] > b [1];
    }
    
    private void sortEnvelopes(int[][] envelopes){
        Comparator<int[]> comparator = new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                int res = Integer.compare(a[0],b[0]);
                if(res != 0) return res;
                else return Integer.compare(b[1],a[1]);
            }
        };
        Arrays.sort(envelopes, comparator);
    }
}