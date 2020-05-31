class Solution {    
    private final int LL = 0;
    private final int TR = 1;
    private final int M = 1000000007;
    
    public int rectangleArea(int[][] rectangles) {
        
        int N = rectangles.length;
        Point[][] rects = new Point[N][2];
        
        for(int i = 0; i < N; i++){
            int[] r = rectangles[i];
            rects[i][LL] = new Point(r[0], r[1]); 
            rects[i][TR] = new Point(r[2], r[3]);
        }        
        
        return computeArea(rects);
    }
    
    private int computeArea(Point[][] rects){
        
        int N = rects.length;
        int E = N*2;
        
        boolean[] active = new boolean[N];
        
        Event[] eventsV = new Event[E], eventsH = new Event[E];

        for(int i = 0; i < N; i++){
            eventsV[i*2] = new Event(i, LL);
            eventsV[i*2+1] = new Event(i, TR);
            eventsH[i*2] = new Event(i, LL);
            eventsH[i*2+1] = new Event(i, TR);
        }
        
        Arrays.sort(eventsV, (Event a, Event b) -> { 
            return rects[a.id][a.type].x < rects[b.id][b.type].x ? -1 : 
            (rects[a.id][a.type].x > rects[b.id][b.type].x ? 1 : 0);}
                   );
        
        Arrays.sort(eventsH, (Event a, Event b) -> {
            return rects[a.id][a.type].y < rects[b.id][b.type].y ? -1 : 
            (rects[a.id][a.type].y > rects[b.id][b.type].y ? 1 : 0);}
                   );
        
        int area = 0;
        active[eventsV[0].id] = true;
        for(int i = 1; i < eventsV.length; i++){
            Event e = eventsV[i];
            Event prev = eventsV[i-1];
            int deltaX = rects[e.id][e.type].x - rects[prev.id][prev.type].x;
            if(deltaX == 0){
                active[e.id] = (e.type == LL);
                continue;
            }
            
            int beginY = 0;
            int overlappingCount = 0;
            
            for(int j = 0; j < E; j++){
                Event hE = eventsH[j];
                if(active[hE.id]){
                    if(hE.type == LL){
                        if(overlappingCount == 0)
                            beginY = rects[hE.id][hE.type].y;
                        overlappingCount++;
                    }else{
                        overlappingCount--;
                        if(overlappingCount == 0){
                            int deltaY = rects[hE.id][hE.type].y - beginY;
                            area += ((long)deltaY * deltaX) % M;
                            area %= M;
                        }
                    }  
                }
            }
            active[e.id] = (e.type == LL);           
        }
        return area;
    }    

    
    public class Event{
        int id;
        int type;
        
        public Event(int id, int type){
            this.id = id;
            this.type = type;
        }        
    }
    
    public class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}