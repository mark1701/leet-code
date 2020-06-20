class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        if(houses == null || houses.length == 0) return 0;
        if(heaters == null || heaters.length == 0) return -1;
        
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int maxRange = Integer.MAX_VALUE;
        int minRange = 0;
        
        while(minRange < maxRange){
            int mid = minRange + (maxRange-minRange)/2; //todo check termination
            if(!gotCoverage(houses, heaters, mid))
                minRange = mid+1;                
            else
                maxRange = mid;
        }
        return minRange;
    }
    
    private boolean gotCoverage(int[] houses, int[] heaters, int range){
        int h = 0, t = 0;
        while(h < houses.length && t < heaters.length){
            if(houses[h] >= heaters[t]-range && houses[h] <= heaters[t]+range)
                h++;
            else
                t++;
        }
        return h == houses.length;        
    }
}