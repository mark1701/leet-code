/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    public void cleanRoom(Robot robot) {        
        Set<String> visited = new HashSet<>();
        visit(robot, 0, 0, visited, 0);
    }
    
    private void visit(Robot robot, int x, int y, Set<String> visited, int dir){
        if(visited.contains(x + " " + y)) return;

        robot.clean();
        visited.add(x + " " + y);
        
        for(int i = 0; i < 4; i++){
            int x1 = x, y1 = y;
            if(robot.move()){
                switch(dir){
                    case 0:
                        x1 = x - 1;
                        break;
                    case 90:
                        y1 = y + 1;
                        break;
                    case 180:
                        x1 = x + 1;
                        break;
                    case 270:
                        y1 = y - 1;
                        break;
                }
                visit(robot, x1, y1, visited, dir);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight();
            dir += 90;
            dir %= 360;            
        }
    }
}