class MedianFinder {

    PriorityQueue<Integer> minHeap, maxHeap;
    int N;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(11, (a,b) -> (b.compareTo(a)));
        
        N = 0;
    }
    
    public void addNum(int num) {
        N++;
        if(!maxHeap.isEmpty() && num <= maxHeap.peek()) maxHeap.offer(num);
        else minHeap.offer(num);
        
        balance();
    }
    
    private void balance(){
        PriorityQueue<Integer> smaller = minHeap.size() <= maxHeap.size() ? minHeap : maxHeap;
        PriorityQueue<Integer> bigger = minHeap.size() <= maxHeap.size() ? maxHeap :minHeap;
        
        if(bigger.size() - smaller.size() > 1)
            smaller.offer(bigger.poll());
    }
    
    public double findMedian() {
        if(N == 0) return 0;
        if(N % 2 == 0) return ((double)(minHeap.peek() + maxHeap.peek()))/2;
        else if(minHeap.size() > maxHeap.size()) return minHeap.peek();
        else return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */