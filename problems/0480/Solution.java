class Solution {
    PriorityQueue<Integer> left, right; 
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length==0) return null;

        int N = nums.length;
        left = new PriorityQueue<Integer>(11,(a,b) -> b.compareTo(a));
        right = new PriorityQueue<Integer>();
        
        double[] res = new double[N-k+1];
        
        for(int i = 0; i <= N; i++){
            
            if(i >= k){
                res[i-k] = getMedian();
                remove(nums[i-k]);
            }
            
            if (i < nums.length) add(nums[i]);
        }
        
        return res;
    }
    
    private void remove(int n){
        if (n < getMedian()) left.remove(n);	    
	    else right.remove(n);
        
	    if(left.size() > right.size()) right.add(left.poll());	
        if(right.size() - left.size() > 1) left.add(right.poll());        
    }
          
    private double getMedian(){
        if (left.isEmpty() && right.isEmpty()) return 0;

        if (left.size() == right.size())
            return ((double)left.peek() + (double)right.peek()) / 2.0;
        
        return (double)right.peek();
    }
    
    private void add(int n){
        if (n < getMedian()) left.add(n);
		else right.add(n);
        
        if(left.size() > right.size()) right.add(left.poll());
        
        if(right.size() - left.size() > 1) left.add(right.poll());    
    }
}