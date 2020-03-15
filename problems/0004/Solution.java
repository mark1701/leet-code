class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	//this is not the requested solution in O(log(n+m)) - this operates in O(indexOfMedian) time
        int n = nums1.length;
        int m = nums2.length;
        
        int medianPos = (n + m) / 2;
        
        int i = -1;
        int j = -1;
        int median = 0;
        int sMedian = 0;
        for(int pos = 0; pos <= medianPos; pos++){
            if(pos == medianPos) sMedian = median;
            if((i+1) < n && (j+1) < m && nums1[i+1] <= nums2[j+1])
                median = nums1[++i];
            else if((i+1) < n && (j+1) < m && nums1[i+1] > nums2[j+1])
                median = nums2[++j];
            else if((i+1) >= n)
                median = nums2[++j];
            else
                median = nums1[++i];            
        }
        
        
        if((n+m) % 2 == 0){
            return (((double) median) + ((double) sMedian)) / 2;
        }
        
        return median;
    }
}