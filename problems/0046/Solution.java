class Solution {    
    
    public int trap(int[] height) {
        if(height == null || height.length < 3) return 0;
        
        int maxL = 0, maxR = 0;
        
        int l = 0, r = height.length - 1;
        int water = 0;
        
        while(l < r){
            if(height[l] < height[r]){
                if(height[l] >= maxL)
                    maxL = height[l];
                else
                    water += maxL - height[l];

                l++;
            } else {
                if(height[r] >= maxR)
                    maxR = height[r];
                else
                    water += maxR - height[r];
                r--;
            }
            
        }
        return water;
    }

}