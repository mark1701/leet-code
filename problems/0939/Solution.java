class Solution {
    public int minAreaRect(int[][] coordinates) {
        Set<Point> points = new HashSet<>();
        
        for(int i = 0; i < coordinates.length; i++){
            points.add(new Point(coordinates[i][0],coordinates[i][1]));
        }
        
        int minArea = Integer.MAX_VALUE;
        
        for(Point pointA : points){
            for(Point pointB : points){
                if(pointA.x > pointB.x && pointA.y > pointB.y){
                Point pointC = new Point(pointA.x,pointB.y);
                Point pointD = new Point(pointB.x,pointA.y);

                if(points.contains(pointC) && points.contains(pointD)){
                    int area = Math.abs(pointA.x - pointB.x) * Math.abs(pointA.y - pointB.y);
                    minArea = Math.min(minArea, area);
                }}
            }
        }
        
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
    
    class Point {
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }

            Point that = (Point) obj;
            return this.x == that.x && this.y == that.y;
        }
    
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 17;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }
    }
}