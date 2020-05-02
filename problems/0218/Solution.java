class Solution {
    public List<List<Integer>> getSkyline(int[][] builds) {
        
        final int START = 0;
        final int END = 1;
        
        BuildingPoint[] points  = new BuildingPoint[builds.length*2];
        
        for(int i = 0; i < builds.length; i++){
            points[2*i] = new BuildingPoint(builds[i][START], builds[i][2], false);
            points[2*i+1] = new BuildingPoint(builds[i][END], builds[i][2], true);
        }
        Arrays.sort(points);
        
        TreeMap<Integer, Integer> queue = new TreeMap<>((a,b) -> b - a);
        queue.put(0,1);
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(BuildingPoint p : points){
            int max = queue.firstKey();
            
            if(!p.isEnd){
                queue.put(p.h, queue.getOrDefault(p.h,0)+1);
            }else{
                if(queue.get(p.h) == 1)
                    queue.remove(p.h);
                else
                    queue.put(p.h, queue.get(p.h)-1);
            }
            
            if(queue.firstKey() != max){
                 List<Integer> point = new ArrayList<>();
                    point.add(p.x);
                    point.add(queue.firstKey());
                    res.add(point);
            }
        }
        
        return res;
        
    }
    private class BuildingPoint implements Comparable<BuildingPoint>{
        int x;
        int h;
        boolean isEnd;
        
        public BuildingPoint(int x, int h, boolean isEnd){
            this.x = x;
            this.h = h;
            this.isEnd = isEnd;            
        }
        
        @Override
        public int compareTo(BuildingPoint that){
            if(this.x != that.x)
                return this.x - that.x;

            if(!this.isEnd && !that.isEnd){ //both start points -> take the highest 
                return that.h - this.h;
            }
            
            if(this.isEnd && that.isEnd){ //both end points -> take the lowest 
                return this.h - that.h;
            }
            
            if(!this.isEnd) //start point go first
                return -1;
            else
                return 1;           
        
        }
    }
   
}